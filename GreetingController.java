package com.springboo.springboot;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    @GetMapping("/")
    public String home() {
        return "Welcome to the Spring Boot API!";
    }

    @GetMapping("/greet/{name}")
    public String greet(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    @GetMapping("/success")
    public ResponseEntity<String> success() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "SuccessHeader");
        return new ResponseEntity<>("Success with custom header", headers, HttpStatus.OK);
    }

    @GetMapping("/not-found")
    public ResponseEntity<String> notFound() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("The requested resource was not found.");
    }

    @PostMapping("/create")
    public ResponseEntity<String> create() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/resource/123");
        return new ResponseEntity<>("Resource created", headers, HttpStatus.CREATED);
    }
}

