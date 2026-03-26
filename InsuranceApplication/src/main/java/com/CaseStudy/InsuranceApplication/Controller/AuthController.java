package com.CaseStudy.InsuranceApplication.Controller;

import com.CaseStudy.InsuranceApplication.Dto.AuthResponse;
import com.CaseStudy.InsuranceApplication.Dto.LoginDto;
import com.CaseStudy.InsuranceApplication.Util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginDto request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUserName(),
                        request.getPassword()
                )
        );

        String token = jwtUtil.generateToken(request.getUserName());

        return new AuthResponse(token);
    }
}
