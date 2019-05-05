package com.turvo.teller.atm.dao;

import com.turvo.teller.atm.domain.Account;
import dbobject.LocalAccountDetails;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class AccountDaoImpl implements AccountDao {

    @Override
    public Account getAccount(int accountNumber) {
        return LocalAccountDetails.getInstance().get(accountNumber);
    }

    @Override
    public List<Account> getAccounts() {
        List<Account> accounts = new ArrayList<>();
        HashMap<Integer, Account> accountNumberToAccount = LocalAccountDetails.getInstance();
        for (Integer accountNo : accountNumberToAccount.keySet()) {
            accounts.add(accountNumberToAccount.get(accountNo));
        }

        return accounts;
    }
}
