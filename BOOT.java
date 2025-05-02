package com.springboo.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BOOT {

    @GetMapping()
    String said(){

        return "aadan";
    }
}
