package com.turvo.teller.atm.controller;

import com.turvo.teller.atm.service.AtmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@EnableAutoConfiguration
public class AtmController {

    @Autowired
    private AtmService atmService;

    @GetMapping("/")
    public String testHome(){
        return "ATM Home application";
    }

    @PostMapping("/deposit")
    public int deposit(@RequestBody int accountNumber, @RequestBody BigDecimal amount) {
        return this.atmService.depositCash(accountNumber, amount);
    }

    @PostMapping("/withdraw")
    public int withdraw(@RequestBody int accountNumber, @RequestBody int pin, @RequestBody BigDecimal amount) {
        return this.atmService.withdrawCash(accountNumber, pin, amount);
    }

   @GetMapping("/balance")
    public BigDecimal balance(@RequestBody int accountNumber, @RequestBody int pin) {
        return this.atmService.requestBalance(accountNumber,pin);
   }

}
