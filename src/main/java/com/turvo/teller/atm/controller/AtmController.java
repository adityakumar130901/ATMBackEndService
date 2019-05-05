package com.turvo.teller.atm.controller;

import com.turvo.teller.atm.domain.Account;
import com.turvo.teller.atm.service.AtmServiceImpl;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@EnableAutoConfiguration
@ComponentScan
public class AtmController {

    private final AtmServiceImpl atmService;

    public AtmController(AtmServiceImpl atmService) {
        this.atmService = atmService;
    }

    @GetMapping("/")
    public String testHome() {
        return "ATM Home application";
    }

    @PostMapping("/deposit")
    public int deposit(@RequestBody int accountNumber, @RequestBody int amount) {
        return this.atmService.depositCash(accountNumber, amount);
    }

    @PostMapping("/withdraw")
    public int withdraw(@RequestBody int accountNumber, @RequestBody int pin, @RequestBody int amount) {
        return this.atmService.withdrawCash(accountNumber, pin, amount);
    }

    @GetMapping("/balance")
    public int balance(@RequestParam int accountNumber, @RequestParam int pin) {
        return this.atmService.requestBalance(accountNumber, pin);
    }

    @GetMapping("/accountInfo")
    public List<Account> accountInfo(){
        return this.atmService.accounts();
    }

}
