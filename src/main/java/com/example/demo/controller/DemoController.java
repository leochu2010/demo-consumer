package com.example.demo.controller;

import com.example.demo.aop.LogExecutionTime;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @LogExecutionTime
    @RequestMapping("/serve")
    public String serve() throws InterruptedException {
        Thread.sleep(2000);
        return "run serve";
    }
}