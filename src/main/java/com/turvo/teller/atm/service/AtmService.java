package com.turvo.teller.atm.service;

import java.math.BigDecimal;

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
        return null;
    }
}
