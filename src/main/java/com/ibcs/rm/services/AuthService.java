package com.ibcs.rm.services;

import com.ibcs.rm.pojo.request.CreateUserRequest;
import com.ibcs.rm.pojo.response.IdentityResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AuthService {


    public ResponseEntity<IdentityResponse> login() {
        return null;
    }

    public ResponseEntity<IdentityResponse> signUp(CreateUserRequest createUserRequest) {
        return null;
    }
}
