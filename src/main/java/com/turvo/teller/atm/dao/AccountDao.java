package com.turvo.teller.atm.dao;

import com.turvo.teller.atm.domain.Account;

import java.util.List;

public interface AccountDao {
    Account getAccount(int accountNumber);

    List<Account> getAccounts();
}
