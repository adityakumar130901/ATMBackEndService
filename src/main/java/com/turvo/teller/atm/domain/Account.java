package com.turvo.teller.atm.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class Account implements Serializable {

    private static final long serialVersionUID = -4830210391324272587L;

    private int accountNumber;

    private BigDecimal accountBalance;

    private int accountPin;

    public int getAccountNumber() {
        return this.accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getAccountBalance() {
        return this.accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    public int getAccountPin() {
        return this.accountPin;
    }

    public void setAccountPin(int accountPin) {
        this.accountPin = accountPin;
    }
}
