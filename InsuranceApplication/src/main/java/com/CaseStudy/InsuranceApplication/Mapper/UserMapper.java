package com.CaseStudy.InsuranceApplication.Mapper;

import com.CaseStudy.InsuranceApplication.Dto.UserDto;
import com.CaseStudy.InsuranceApplication.Entity.Users;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    // Entity to DTO
    UserDto userDto(Users users);
    // Dto to entity
    Users user(UserDto userDto);
}
