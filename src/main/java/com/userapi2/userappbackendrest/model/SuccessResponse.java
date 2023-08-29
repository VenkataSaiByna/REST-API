package com.userapi2.userappbackendrest.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SuccessResponse {
    private String status;
    private String message;
    private Person person;
}
