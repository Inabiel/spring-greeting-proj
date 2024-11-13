package com.example.springgreetingproj.controller;

import com.example.springgreetingproj.model.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicInteger counter = new AtomicInteger();


    @GetMapping(value = {"/greeting","/greeting/{name}"})
    public Greeting greeting(@PathVariable(required = false) String name) {
        if (Objects.equals(name, null)){
            name = "World";
        }
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
