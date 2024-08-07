package com.ashfaq.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mshealth")
public class StatusController {

    @GetMapping("/status")
    public String getStatus() {
        return "I'm up!";
    }
}