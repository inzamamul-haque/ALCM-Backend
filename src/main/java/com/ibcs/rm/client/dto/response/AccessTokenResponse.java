package com.ibcs.rm.client.dto.response;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccessTokenResponse {

    private String token;
}
