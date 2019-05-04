package com.turvo.teller.atm.service;

import com.turvo.teller.atm.domain.Account;
import dbobject.LocalAccountDetails;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

    @Override
    public List<Account> accounts() {
        List<Account> accounts = new ArrayList<>();
        HashMap<Integer,Account> accountNumberToAccount = LocalAccountDetails.getInstance();
        for(Integer accountNo : accountNumberToAccount.keySet()) {
            accounts.add(accountNumberToAccount.get(accountNo));
        }
        return accounts;
    }
}
