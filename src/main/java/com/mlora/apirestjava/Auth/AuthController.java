package com.mlora.apirestjava.Auth;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@RequestMapping("/auth")
@RestController
public class AuthController {
    @PostMapping("/login")
    public String login() {
        return "login";
    }
    @PostMapping("/register")
    public String register() {
        return "register";
    }
}
