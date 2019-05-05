package com.turvo.teller.atm.controller;

import com.turvo.teller.atm.domain.Account;
import com.turvo.teller.atm.service.AtmServiceImpl;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(path = "/deposit/{accountNumber}/{amount}")
    public int deposit(@PathVariable int accountNumber, @PathVariable int amount) {
        return this.atmService.depositCash(accountNumber, amount);
    }

    @PostMapping(path="/withdraw/{accountNumber}/{pin}/{amount}")
    public int withdraw(@PathVariable int accountNumber, @PathVariable int pin, @PathVariable int amount) {
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
