package com.userapi2.userappbackendrest.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FailureResponse {
    private String status;
    private String code;
    private String message;
}
