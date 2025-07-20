package com.digibank.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "👋 Bem-vindo à API DigiBank! Use os endpoints em /contas para interagir.";
    }
}
