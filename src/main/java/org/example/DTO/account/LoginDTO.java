package org.example.DTO.account;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginDTO {
    private String email;
    private String password;
}