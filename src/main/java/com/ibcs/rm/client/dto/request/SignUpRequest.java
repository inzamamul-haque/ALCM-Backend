package com.ibcs.rm.client.dto.request;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequest {

    private String userId;

    private String username;

    private Set<String> role;

    private String password;


}
