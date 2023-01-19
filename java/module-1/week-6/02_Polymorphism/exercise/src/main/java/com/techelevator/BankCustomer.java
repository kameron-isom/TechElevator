package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class BankCustomer {
    private String name;
    private String address;
    private String phoneNumber;
   private static final int ACCOUNTISVIP= 25000;

    public List<Accountable> accounts= new ArrayList<>();

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(){
        this.address=address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber (){
        this.phoneNumber = phoneNumber;
    }

    public static int getACCOUNTISVIP() {
        return ACCOUNTISVIP;
    }

    public BankCustomer(){
        super();

    }


    public Accountable [] getAccounts(){
        return accounts.toArray(new Accountable[0]);
    }

    public void addAccount(Accountable newAccount){
        accounts.add(newAccount);
    }

    public boolean isVIP(){
        if (getAccounts().length >= ACCOUNTISVIP){
            return true;
        }


    return false;
    }

}
