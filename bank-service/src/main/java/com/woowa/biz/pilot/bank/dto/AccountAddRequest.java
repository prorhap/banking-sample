package com.woowa.biz.pilot.bank.dto;


public class AccountAddRequest {

    private String userName;
    private String accountNumber;
    private String description;

    public String getUserName() {
        return userName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "AccountAddRequest{" +
                "userName='" + userName + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
