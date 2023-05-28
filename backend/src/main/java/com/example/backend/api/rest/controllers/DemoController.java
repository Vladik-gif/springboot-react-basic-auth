package com.example.backend.api.rest.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class DemoController {

    private static final String USER = "/user";
    private static final String ADMIN = "/admin";

    @GetMapping(USER)
    public ResponseEntity<String> user(){
        return ResponseEntity.ok("Hello, user");
    }

    @GetMapping(ADMIN)
    public ResponseEntity<String> admin(){
        return ResponseEntity.ok("Hello, admin");
    }

}
