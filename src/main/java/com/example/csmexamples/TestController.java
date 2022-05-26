package com.example.csmexamples;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping(value = "/")
    public String getData() {
        return "wut";
    }

    @GetMapping(value = "/cases")
    public String getCases(Name name) {
        return String.format("First name is %s and last name is %s.", name.getFirstName(), name.getLastName());
    }
}
