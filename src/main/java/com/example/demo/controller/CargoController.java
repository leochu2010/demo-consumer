package com.example.demo.controller;

import com.example.demo.kafka.Cargo;
import com.example.demo.kafka.CargoConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CargoController {

    @Autowired
    private CargoConsumerService cargoConsumerService;

    @GetMapping("cargos")
    public Iterable<Cargo> getAllCargos() {
        return cargoConsumerService.getAllCargos();
    }
}
