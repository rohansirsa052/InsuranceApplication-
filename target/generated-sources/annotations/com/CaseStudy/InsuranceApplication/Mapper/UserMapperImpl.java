package com.CaseStudy.InsuranceApplication.Mapper;

import com.CaseStudy.InsuranceApplication.Dto.UserDto;
import com.CaseStudy.InsuranceApplication.Entity.Users;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-02-04T14:57:49+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto userDto(Users users) {
        if ( users == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setUserName( users.getUserName() );
        userDto.setPassword( users.getPassword() );
        userDto.setEmail( users.getEmail() );
        userDto.setRole( users.getRole() );

        return userDto;
    }

    @Override
    public Users user(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        Users users = new Users();

        users.setUserName( userDto.getUserName() );
        users.setPassword( userDto.getPassword() );
        users.setEmail( userDto.getEmail() );
        users.setRole( userDto.getRole() );

        return users;
    }
}
