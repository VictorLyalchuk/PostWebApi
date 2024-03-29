package org.example.controllers;

import lombok.RequiredArgsConstructor;
import org.example.DTO.account.AuthResponseDTO;
import org.example.DTO.account.LoginDTO;
import org.example.DTO.account.RegistrationDTO;
import org.example.Services.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/account")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService service;

    @PostMapping("login")
    public ResponseEntity<Object> login(@RequestBody LoginDTO dto) {
        try {
            var auth = service.login(dto);
            return ResponseEntity.ok(auth);
        }
        catch (Exception ex) {
            return ResponseEntity.badRequest().body("Невірно введені дані! Спробуйте ще раз!");
        }
    }
    @PostMapping("register")
    public ResponseEntity<AuthResponseDTO> register(@RequestBody RegistrationDTO dto) {
        try {
            var reg = service.registration(dto);
            return ResponseEntity.ok(reg);
        }
        catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}