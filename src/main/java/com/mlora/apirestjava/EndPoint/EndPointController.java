package com.mlora.apirestjava.EndPoint;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class EndPointController {

    @PostMapping(value = "demo")
    public String welcome() {
        return "Welcome from secure endpoint";
    }
}
