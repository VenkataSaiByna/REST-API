package com.userapi2.userappbackendrest.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Auth {
    private String userName;
    private String password;
}
