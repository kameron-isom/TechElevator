package com.techelevator;

public class CheckingAccount extends BankAccount {

    public static final int OVERDRAFT_FEE = 10;
    public static final int MINIMUM_LIMIT = -100;

    public CheckingAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }

    public CheckingAccount(String accountHolderName, String accountNumber, int balance) {
        super(accountHolderName, accountNumber, balance);
    }

    @Override
    public int withdraw(int amountToWithDraw) {
        if (getBalance() - amountToWithDraw > MINIMUM_LIMIT) {
            super.withdraw(amountToWithDraw);
            if (getBalance() < 0) {
                super.withdraw(OVERDRAFT_FEE);
            }

        }
        return getBalance();
    }
    }


