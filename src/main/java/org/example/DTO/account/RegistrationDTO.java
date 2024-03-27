package org.example.DTO.account;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class RegistrationDTO {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String phone;

}