package org.example.mapper;

import org.example.DTO.account.RegistrationDTO;
import org.example.entities.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RegistrationMapper {
    UserEntity registrationEntity(RegistrationDTO dto);
    RegistrationDTO RegistrationDTO(UserEntity user);
}
