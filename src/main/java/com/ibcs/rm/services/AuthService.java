package com.ibcs.rm.services;

import com.ibcs.rm.client.UaaClientService;
import com.ibcs.rm.client.dto.request.SignUpRequest;
import com.ibcs.rm.configuration.Utility;
import com.ibcs.rm.domain.model.User;
import com.ibcs.rm.domain.repository.UserRepository;
import com.ibcs.rm.pojo.request.CreateUserRequest;
import com.ibcs.rm.pojo.response.IdentityResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final UaaClientService uaaClientService;

    public ResponseEntity<IdentityResponse> login() {
        return null;
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
}
