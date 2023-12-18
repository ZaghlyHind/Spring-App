package com.example.cvtheque.resource;

import org.springframework.web.bind.annotation.GetMapping;

public class TestResource {
    @GetMapping("/buggy")
    public String buggyMethod() {
        int result = 10 / 0; // Division by zero (intentional bug)
        return "Result: " + result;
    }

}
