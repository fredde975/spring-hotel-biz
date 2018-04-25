package com.example.hotelbiz.controllers;

import com.example.hotelbiz.entities.Greeting;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HotelRestController {

    @GetMapping("/rest")
    public Greeting sayHello(@RequestParam(defaultValue = "World") String name){
        return new Greeting("Hello, " + name);
    }
}
