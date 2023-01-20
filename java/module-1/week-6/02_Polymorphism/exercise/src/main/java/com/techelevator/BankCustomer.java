package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class BankCustomer {
    private String name;
    private String address;
    private String phoneNumber;
    private static final int ACCOUNTISVIP = 25000;

    private List<Accountable> accounts = new ArrayList<>();



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Accountable[] getAccounts() {
        return accounts.toArray(new Accountable[accounts.size()]);
    }

    public void addAccount(Accountable account) {
        accounts.add(account);
    }

    public boolean isVip() {
        int total = 0;
        for (Accountable account : accounts) {
            total += account.getBalance();
        }
        if(total >= ACCOUNTISVIP){
            return true;
        }
        return false;
    }
}


