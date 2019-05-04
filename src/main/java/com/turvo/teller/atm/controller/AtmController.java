package com.turvo.teller.atm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AtmController {

    @GetMapping("/")
    public String testHome(){
        return "ATM Home application";
    }
}
