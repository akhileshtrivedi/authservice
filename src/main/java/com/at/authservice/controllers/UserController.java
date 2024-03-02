package com.at.authservice.controllers;

import com.at.authservice.dtos.LoginRequestDto;
import com.at.authservice.dtos.LogoutRequestDto;
import com.at.authservice.dtos.SignUpRequestDto;
import com.at.authservice.dtos.SignUpResponseDto;
import com.at.authservice.models.Token;
import com.at.authservice.models.User;
import com.at.authservice.services.UserService;
import lombok.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${api.v1.baseUrl}/users")
public class UserController {
    private UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping({"/login", "/signin"})
    public Token login(@RequestBody LoginRequestDto requestDto) {
        // check if email and password in db
        // if yes create token (use random string) return token
        // else throw some error
        return userService.login(requestDto.getEmail(), requestDto.getPassword());
    }

    @PostMapping({"/signup", "/registration"})

    public SignUpResponseDto signUp(@RequestBody SignUpRequestDto requestDto) {

        // hash password
        // create user
        // return user
        return toSignUpResponseDto(userService.signUp(requestDto.getName(), requestDto.getEmail(), requestDto.getPassword()));
    }

    @PostMapping({"/logout", "/signout"})
    public ResponseEntity<Void> logout(@RequestBody LogoutRequestDto requestDto) {
        // delete token if exists -> 200
        // if doesn't exist give a 404

        userService.logout(requestDto.getToken());
        return ResponseEntity.ok().build(); // or throw an exception, based on your error handling policy
    }

    public SignUpResponseDto toSignUpResponseDto(User user) {
        if (user == null) {
            return null; // Or throw an exception, based on your error handling policy
        }

        SignUpResponseDto dto = new SignUpResponseDto();
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setEmailVerified(user.isEmailVerified());

        return dto;
    }

    @PostMapping("/validate/{token}")
    public User validateToken(@PathVariable("token") @NonNull String token) {
        return userService.validateToken(token);
    }
}
