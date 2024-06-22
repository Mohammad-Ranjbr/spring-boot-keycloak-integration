package com.example.keycloak.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/demo")
public class DemoController {

    @GetMapping
    @PreAuthorize("hasRole('client_user')")
    public ResponseEntity<String> sayHello(){
        return new ResponseEntity<>("Hello from Spring Boot & Keycloak", HttpStatus.OK);
    }

    @GetMapping("/hello-2")
    @PreAuthorize("hasRole('client_admin')")
    public ResponseEntity<String> sayHello2(){
        return new ResponseEntity<>("Hello from Spring Boot & Keycloak - ADMIN",HttpStatus.OK);
    }

}
