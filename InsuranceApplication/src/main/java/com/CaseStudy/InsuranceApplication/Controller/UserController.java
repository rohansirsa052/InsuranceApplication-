package com.CaseStudy.InsuranceApplication.Controller;

import com.CaseStudy.InsuranceApplication.Dto.ApplicationFormDto;
import com.CaseStudy.InsuranceApplication.Dto.LoginDto;
import com.CaseStudy.InsuranceApplication.Dto.UserDto;
import com.CaseStudy.InsuranceApplication.Entity.ApplicationForm;
import com.CaseStudy.InsuranceApplication.Entity.InsurancePlans;
import com.CaseStudy.InsuranceApplication.Entity.Users;
import com.CaseStudy.InsuranceApplication.Service.ApplicationService;
import com.CaseStudy.InsuranceApplication.Service.InsurancePlansService;
import com.CaseStudy.InsuranceApplication.Service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    ApplicationService applicationService;

    @Autowired
    InsurancePlansService insurancePlansService;

    @GetMapping("")
    public String sayHello(){
        return "Hello from user";
    }

    @GetMapping("/allUsers")
    public ResponseEntity <List<UserDto>> getAllUsers(){
        List <UserDto> usersList = userService.findAll();
        return new ResponseEntity<>(usersList, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto){
        UserDto addedUser  = userService.addUser(userDto);
        return new ResponseEntity<>(addedUser, HttpStatus.CREATED);
    }

    @GetMapping("/login")
    public ResponseEntity<String> userLogin(@RequestBody LoginDto loginDto){
        String result = userService.loginUser(loginDto.getUserName(),loginDto.getPassword());
         if(result.equals("User not found")){
             return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
         }
         else if(result.equals("Invalid password")){
             return new ResponseEntity<>(result, HttpStatus.UNAUTHORIZED);
         }
         else return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @PostMapping("/apply")
    public ResponseEntity <ApplicationForm> apply(@RequestBody ApplicationFormDto form){
        ApplicationForm savedForm = applicationService.saveFrom(form);
        return new ResponseEntity<>(savedForm, HttpStatus.CREATED);
    }
    @GetMapping("/plans")
    public ResponseEntity <List<InsurancePlans>> getAllPlans(){
        List<InsurancePlans>  insurancePlans = insurancePlansService.findAll();
        return new ResponseEntity<>(insurancePlans, HttpStatus.OK);
    }
}
