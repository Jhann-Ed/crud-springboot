package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @GetMapping("/")
    public String hello() {
        return "Hello World!";
    }

    @GetMapping("/{name}")
    public String grettings(@PathVariable("name") String name) {
        return "Hola " + name + "!";
    }

    @GetMapping("/{name}/{age}")
    public String grettingWitihAge(
            @PathVariable("name") String name,
            @PathVariable("age") int age
    ) {
        return "Hola" +name+ " de " + age + " tienes años";
    }

}
