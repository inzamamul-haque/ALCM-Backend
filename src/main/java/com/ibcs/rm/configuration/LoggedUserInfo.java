package com.ibcs.rm.configuration;


import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Setter
@Getter
public class LoggedUserInfo {

    private String loggedUserId;

    private List<String> roles;

    private boolean isAuthenticate;

    private boolean isLogged;

    private String loggedUserName;

    private String loggedUserPhoneNumber;

    private String loggedUserEmail;

    private String loggedUserAddress;

    private boolean loggedUserAccountIsActive;


}
