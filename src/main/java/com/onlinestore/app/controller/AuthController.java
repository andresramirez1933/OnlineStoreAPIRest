package com.onlinestore.app.controller;

import com.onlinestore.app.payload.JwtAuthResponse;
import com.onlinestore.app.payload.LoginDTO;
import com.onlinestore.app.entity.Role;
import com.onlinestore.app.payload.SignUpDTO;
import com.onlinestore.app.entity.User;
import com.onlinestore.app.repository.RoleRepository;
import com.onlinestore.app.repository.UserRepository;
import com.onlinestore.app.security.JwtTokenProvider;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Collections;

@Api(value = "Auth controller allows user to signup and log in")
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;


    @ApiOperation(value = "Log in the online store REST API")
    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponse> logIn(@Valid @RequestBody LoginDTO loginDto){

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsernameOrEmail(), loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        //generate token
        String token = jwtTokenProvider.generateToken(authentication);

        return new ResponseEntity<>( new JwtAuthResponse(token), HttpStatus.OK);
    }

    @ApiOperation(value = "Sign up the online store REST API")
    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@Valid @RequestBody SignUpDTO signUpDTO){

        if(userRepository.existsByUsername(signUpDTO.getUsername())){

            return new ResponseEntity<>("Username already exists", HttpStatus.BAD_REQUEST);
        }

        if(userRepository.existsByEmail(signUpDTO.getEmail())){

            return new ResponseEntity<>("Email already exists", HttpStatus.BAD_REQUEST);
        }

        User user = new User();
        user.setName(signUpDTO.getName());
        user.setUsername(signUpDTO.getUsername());
        user.setEmail(signUpDTO.getEmail());
        user.setPassword(passwordEncoder.encode(signUpDTO.getPassword()));

        Role role = roleRepository.findByName("ROLE_ADMIN").get();



        user.setRoles(Collections.singleton(role));

        userRepository.save(user);

        return new ResponseEntity<>("User created", HttpStatus.CREATED);


    }



}
