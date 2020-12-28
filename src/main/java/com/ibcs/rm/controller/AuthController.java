package com.ibcs.rm.controller;

import com.ibcs.rm.pojo.request.CreateUserRequest;
import com.ibcs.rm.pojo.request.LoginRequest;
import com.ibcs.rm.pojo.response.IdentityResponse;
import com.ibcs.rm.services.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("public/")
public class AuthController {
    private final AuthService authService;

    @PostMapping("login")
    public ResponseEntity<IdentityResponse> login(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }

    @PostMapping("signUp")
    public ResponseEntity<IdentityResponse> create(@RequestBody CreateUserRequest createUserRequest) {
        return authService.signUp(createUserRequest);
    }


}
