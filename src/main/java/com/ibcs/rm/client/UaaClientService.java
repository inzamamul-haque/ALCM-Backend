package com.ibcs.rm.client;


import com.ibcs.rm.client.dto.request.LoginClientRequest;
import com.ibcs.rm.client.dto.request.ResetPasswordForm;
import com.ibcs.rm.client.dto.request.SignUpRequest;
import com.ibcs.rm.client.dto.response.AccessTokenResponse;
import com.ibcs.rm.client.dto.response.LoggedUserDetailsResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Service
@FeignClient(value = "UaaClientService", url = "http://localhost:20230/")
public interface UaaClientService {

    @PostMapping("public/signin")
    Optional<AccessTokenResponse> login(LoginClientRequest loginRequest);

    @PostMapping("public/signup")
    Optional<String> signUp(SignUpRequest signUpRequest);

    @PutMapping("public/reset/user/{userId}")
    Optional<String> reset(ResetPasswordForm resetPasswordForm, @PathVariable("userId") String userId);

    @GetMapping("user-details")
    Optional<LoggedUserDetailsResponse> getLoggedUserDetails(@RequestHeader("Authorization") String authorizationHeader);


}
