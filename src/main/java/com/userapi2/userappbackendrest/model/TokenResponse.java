package com.userapi2.userappbackendrest.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TokenResponse {
    private String status;
    private String message;
    private Token data;
}
