package org.example.Services;

import lombok.RequiredArgsConstructor;
import org.example.DTO.account.RegistrationDTO;
import org.example.configuration.security.JwtService;
import org.example.DTO.account.AuthResponseDTO;
import org.example.DTO.account.LoginDTO;
import org.example.constants.Roles;
import org.example.entities.UserEntity;
import org.example.entities.UserRoleEntity;
import org.example.mapper.CategoryMapper;
import org.example.mapper.RegistrationMapper;
import org.example.repositories.CategoryRepository;
import org.example.repositories.RoleRepository;
import org.example.repositories.UserRepository;
import org.example.repositories.UserRoleRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    private final RegistrationMapper registrationMapper;

    public AuthResponseDTO login(LoginDTO request) {
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow();
        var isValid = passwordEncoder.matches(request.getPassword(), user.getPassword());
        if (!isValid) {
            throw new UsernameNotFoundException("User not found");
        }
        var jwtToekn = jwtService.generateAccessToken(user);
        return AuthResponseDTO.builder()
                .token(jwtToekn)
                .build();
    }

    public RegistrationDTO registration(RegistrationDTO dto) {
        if (userRepository.findByEmail(dto.getEmail()).isPresent()) {
            throw new IllegalStateException("User with email " + dto.getEmail() + " already exists.");
        }
        var user = registrationMapper.registrationEntity(dto);
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        userRepository.save(user);

        var role = roleRepository.findByName(Roles.User);
        var ur = UserRoleEntity
                .builder()
                .role(role)
                .user(user)
                .build();
        userRoleRepository.save(ur);
        return registrationMapper.RegistrationDTO(user);
    }
}