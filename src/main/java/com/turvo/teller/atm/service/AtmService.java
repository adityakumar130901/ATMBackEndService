package com.turvo.teller.atm.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AtmService implements AtmServiceImpl {

    @Override
    public int depositCash(int accountNumber, BigDecimal amount) {
        return 0;
    }

    @Override
    public int withdrawCash(int accountNumber, int pin, BigDecimal amount) {
        return 0;
    }

    @Override
    public BigDecimal requestBalance(int accountNumber, int pin) {
        BigDecimal bigDecimal = new BigDecimal(2);
        return bigDecimal;
    }
}
