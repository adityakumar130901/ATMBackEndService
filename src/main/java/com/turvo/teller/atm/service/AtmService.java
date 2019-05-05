package com.turvo.teller.atm.service;

import com.turvo.teller.atm.domain.Account;

import java.math.BigDecimal;
import java.util.List;

public interface AtmService {

    public int depositCash(int accountNumber, BigDecimal amount);

    public int withdrawCash(int accountNumber, int pin, BigDecimal amount);

    public int requestBalance(int accountNumber, int pin);

    public List<Account> accounts();
}
