package com.ibcs.rm.pojo.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
public class CreateUserRequest {

    private String name;

    private String userName;

    private String email;

    private String phoneNo;

    private Set<String> roles;

    private String password;
}
