package com.CaseStudy.InsuranceApplication.Service;

import com.CaseStudy.InsuranceApplication.Dto.UserDto;
import com.CaseStudy.InsuranceApplication.Entity.Users;
import com.CaseStudy.InsuranceApplication.Mapper.UserMapper;
import com.CaseStudy.InsuranceApplication.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    UserRepo  userRepo;

    public UserDto addUser(UserDto userDto) {
        Users savedUser = userRepo.save(UserMapper.INSTANCE.user(userDto));
        return UserMapper.INSTANCE.userDto(savedUser);
    }

    public  String loginUser(String username, String password) {
        Users user = userRepo.findByUserName(username);
        if (user == null) {
            return "User not found";
        }
        if (!user.getPassword().equals(password)) {
            return "Invalid password";
        }
        return "User logged in successfully";
    }

    public List<UserDto> findAll() {
        List <Users> usersList = userRepo.findAll();
        return usersList
                .stream()
                .map(user -> UserMapper.INSTANCE.userDto(user))
                .collect(Collectors.toList());
    }
}
