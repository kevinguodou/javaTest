package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class service {

    @RequestMapping("/hi")
    public String toString() {
        return "HELLOW WORLD";
    }
}
