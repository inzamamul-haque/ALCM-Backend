package com.ibcs.rm.services;

import com.ibcs.rm.client.UaaClientService;
import com.ibcs.rm.client.dto.request.LoginClientRequest;
import com.ibcs.rm.client.dto.request.SignUpRequest;
import com.ibcs.rm.client.dto.response.AccessTokenResponse;
import com.ibcs.rm.client.dto.response.LoggedUserDetailsResponse;
import com.ibcs.rm.configuration.LoggedUserInfo;
import com.ibcs.rm.configuration.Utility;
import com.ibcs.rm.domain.model.User;
import com.ibcs.rm.domain.repository.UserRepository;
import com.ibcs.rm.exception.ForbiddenException;
import com.ibcs.rm.pojo.request.CreateUserRequest;
import com.ibcs.rm.pojo.request.LoginRequest;
import com.ibcs.rm.pojo.response.IdentityResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final UaaClientService uaaClientService;
    private final LoggedUserInfo loggedUserInfoUtil;

    public ResponseEntity<IdentityResponse> login(LoginRequest loginRequest) {

        Optional<AccessTokenResponse> accessTokenResponseOptional = uaaClientService.login(
                new LoginClientRequest(loginRequest.getUserName(), loginRequest.getPassword()));
        if (!accessTokenResponseOptional.isPresent()) {
            return new ResponseEntity(new AccessTokenResponse("User Not Registered"), HttpStatus.FORBIDDEN);
        }
        pinkByAccessToken("Bearer " + accessTokenResponseOptional.get().getToken());
        AccessTokenResponse tokenResponse = new AccessTokenResponse(accessTokenResponseOptional.get().getToken());
        return new ResponseEntity(tokenResponse, HttpStatus.OK);

    }

    public ResponseEntity<IdentityResponse> signUp(CreateUserRequest createUserRequest) {

        String uuid = Utility.getRandomUuid();
        SignUpRequest signUpRequest = new SignUpRequest();
        signUpRequest.setUserId(uuid);
        signUpRequest.setUsername(createUserRequest.getUserName());
        signUpRequest.setRole(createUserRequest.getRoles());
        signUpRequest.setPassword(createUserRequest.getPassword());

        Optional<String> userId = uaaClientService.signUp(signUpRequest);
        if (!userId.isPresent()) {
            throw new RuntimeException("User Not Created");
        }
        User user = new User();
        user.setId(userId.get());
        user.setUserName(createUserRequest.getUserName());
        user.setEmail(createUserRequest.getEmail());
        user.setName(createUserRequest.getName());
        user.setPhoneNo(createUserRequest.getPhoneNo());
        userRepository.save(user);

        return new ResponseEntity(new IdentityResponse(uuid), HttpStatus.OK);
    }

    public void pink(HttpServletRequest httpServletRequest) {
        String header = httpServletRequest.getHeader("Authorization");
        if (header == null) {
            throw new ForbiddenException("Header Not Found");
        }

        Optional<LoggedUserDetailsResponse> loggedUserDetailsResponseOptional = uaaClientService.getLoggedUserDetails(header);

        if (!loggedUserDetailsResponseOptional.isPresent()) {
            throw new ForbiddenException("Not Registered User ");
        }
        LoggedUserDetailsResponse loggedUserDetailsResponse = loggedUserDetailsResponseOptional.get();

        System.out.println("Logged User Role" + loggedUserDetailsResponse.getUserRole());
        System.out.println("Logged User Name" + loggedUserDetailsResponse.getUserName());

        Optional<User> optionalUser = userRepository.findUserByUserNameNative(loggedUserDetailsResponse.getUserName());

        if (!optionalUser.isPresent()) {
            throw new ForbiddenException("User Info Not Found");
        }
        User user = optionalUser.get();
        loggedUserInfoUtil.setLogged(true);
        loggedUserInfoUtil.setLoggedUserEmail(user.getEmail());
        loggedUserInfoUtil.setLoggedUserId(user.getId());
        loggedUserInfoUtil.setLoggedUserName(user.getUserName());
        loggedUserInfoUtil.setLoggedUserPhoneNumber(user.getPhoneNo());
        loggedUserInfoUtil.setLoggedUserName(user.getName());
        loggedUserInfoUtil.setRoles(loggedUserDetailsResponse.getUserRole());
    }

    public boolean pinkByAccessToken(String token) {

        Optional<LoggedUserDetailsResponse> loggedUserDetailsResponseOptional
                = uaaClientService.getLoggedUserDetails(token);
        if (!loggedUserDetailsResponseOptional.isPresent()) {
            throw new ForbiddenException("User Not Registered");
        }
        LoggedUserDetailsResponse loggedUserDetailsResponse = loggedUserDetailsResponseOptional.get();
        System.out.println("Logged User role: " + loggedUserDetailsResponse.getUserRole());

        Optional<User> optionalUser = userRepository.findUserByUserNameNative(loggedUserDetailsResponse.getUserName());
        if (!optionalUser.isPresent()) {
            throw new ForbiddenException("User Info Not Found");
        }

        User user = optionalUser.get();
        loggedUserInfoUtil.setLogged(true);
        loggedUserInfoUtil.setLoggedUserEmail(user.getEmail());
        loggedUserInfoUtil.setLoggedUserId(user.getId());
        loggedUserInfoUtil.setLoggedUserName(user.getUserName());
        loggedUserInfoUtil.setLoggedUserPhoneNumber(user.getPhoneNo());
        loggedUserInfoUtil.setLoggedUserName(user.getName());
        loggedUserInfoUtil.setRoles(loggedUserDetailsResponse.getUserRole());

        return true;
    }
}
