package com.techelevator;

public class BankAccount {
    // instance variables
    private String accountHolderName;
    private String accountNumber;
    private int balance = 0;

    // constructors
    public BankAccount(String accountHolderName, String accountNumber, int balance){
        this.accountHolderName= accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public BankAccount(String accountHolderName, String accountNumber) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
    }
    public BankAccount(){

    }



        // getters and setters
    public String getAccountHolderName() {
        return accountHolderName;
    }

    public String getAccountNumber(){
        return accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    // Method

    public int deposit( int amountToDeposit){
        balance = balance + amountToDeposit;
    return  balance;
    }

    public int withdraw(int amountToWithDraw){
        balance= balance - amountToWithDraw;
     return balance;
    }
}
