package com.userapi2.userappbackendrest.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Token {
    private String token;
    private String expireTime;
}
