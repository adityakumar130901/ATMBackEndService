package com.turvo.teller.atm.service;

import com.turvo.teller.atm.dao.AccountDao;
import com.turvo.teller.atm.domain.Account;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AtmServiceImpl implements AtmService {

    private static final int CANT_DEPOSIT_NEGATIVE_CASH = -1;
    private static final int ACCOUNT_INVALID = -2;
    private static final int ACCOUNT_PIN_NOT_MATCHING = -3;
    private static final int BALANCE_NOT_SUFFICIENT_TO_WITHDRAW = -4;

    private final AccountDao accountDao;

    public AtmServiceImpl(final AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public int depositCash(int accountNumber, int amount) {
        if (isAccountValid(accountNumber)) {
            if (amount < 0) {
                return CANT_DEPOSIT_NEGATIVE_CASH;
            }

            final Account account = this.accountDao.getAccount(accountNumber);
            synchronized (account) {
                BigDecimal currentBalance = account.getAccountBalance();
                currentBalance.add(new BigDecimal(amount));
                account.setAccountBalance(currentBalance);
                return currentBalance.intValue();
            }
        } else {
            return ACCOUNT_INVALID;
        }
    }

    private boolean isAccountValid(int accountNumber) {
        return this.accountDao.getAccount(accountNumber) != null;
    }

    @Override
    public int withdrawCash(int accountNumber, int pin, int withdrawlAmount) {
        int currentBalance = requestBalance(accountNumber, pin);

        // Error case
        if (currentBalance < 0) {
            return currentBalance;
        } else {
            if (currentBalance > withdrawlAmount) {
                final Account account = this.accountDao.getAccount(accountNumber);
                synchronized (account) {
                    int requestedBalance = account.getAccountBalance().intValue();
                    requestedBalance = requestedBalance - withdrawlAmount;
                    account.setAccountBalance(new BigDecimal(requestedBalance));
                    return requestedBalance;
                }
            } else {
                return BALANCE_NOT_SUFFICIENT_TO_WITHDRAW;
            }
        }
    }

    @Override
    public int requestBalance(int accountNumber, int pin) {
        if (isAccountValid(accountNumber)) {
            if (isAccountPinMatching(accountNumber, pin)) {
                final Account account = this.accountDao.getAccount(accountNumber);
                synchronized (account) {
                    final BigDecimal currentBalance = account.getAccountBalance();
                    return currentBalance.intValue();
                }
            } else {
                return ACCOUNT_PIN_NOT_MATCHING;
            }
        } else {
            return ACCOUNT_INVALID;
        }
    }

    private boolean isAccountPinMatching(int accountNumber, int pin) {
        final Account account = this.accountDao.getAccount(accountNumber);
        return account.getAccountPin() == pin;
    }

    @Override
    public List<Account> accounts() {
        return this.accountDao.getAccounts();
    }
}
