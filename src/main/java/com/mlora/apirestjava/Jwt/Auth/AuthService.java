package com.mlora.apirestjava.Jwt.Auth;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.authentication.AuthenticationManager;


import com.mlora.apirestjava.Jwt.JwtProvider;
import com.mlora.apirestjava.User.Role;
import com.mlora.apirestjava.User.User;
import com.mlora.apirestjava.User.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    
    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails user=userRepository.findByUsername(request.getUsername()).orElseThrow();
        String token=jwtProvider.getToken(user);
        return AuthResponse.builder()
            .token(token)
            .build();

    }


    public AuthResponse register(RegisterRequest request) {
        User user = User.builder().username(request.getUsername()).password(passwordEncoder.encode( request.getPassword())).firstname(request.getFirstname()).lastname(request.getLastname()).country(request.getCountry()).role(Role.USER).build();
        userRepository.save(user);
        return AuthResponse.builder().token(jwtProvider.getToken(user)).build();
    }

}
