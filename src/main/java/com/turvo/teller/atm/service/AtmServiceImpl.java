package com.turvo.teller.atm.service;

import java.math.BigDecimal;

public interface AtmServiceImpl {

    public int depositCash(int accountNumber, BigDecimal amount);

    public int withdrawCash(int accountNumber, int pin, BigDecimal amount);

    public BigDecimal requestBalance(int accountNumber, int pin);
}
