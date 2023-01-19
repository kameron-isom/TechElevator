package com.techelevator;

public class SavingsAccount extends BankAccount{

    public static final int SERVICE_FEE=2;
    public static final int MINIMUM_BALANCE_FOR_FEE= 150;
    public static final int MINIMUM_BALANCE= 2;

    public SavingsAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }
    public SavingsAccount (String accountHolderName, String accountNumber, int balance) {
        super(accountHolderName, accountNumber, balance);
    }

    @Override
    public int withdraw (int amountToWithDraw) {
        if (getBalance() - amountToWithDraw >= MINIMUM_BALANCE_FOR_FEE) {
            return super.withdraw(amountToWithDraw);
        }
            if (getBalance() - amountToWithDraw >= MINIMUM_BALANCE ) {
               super.withdraw(amountToWithDraw);
                super.withdraw(SERVICE_FEE);
            }

        return getBalance();

        }
    }

