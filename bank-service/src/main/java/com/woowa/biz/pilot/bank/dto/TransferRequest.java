package com.woowa.biz.pilot.bank.dto;

public class TransferRequest {

    private String sourceAccountNumber;
    private String targetAccountNumber;
    private int amount;

    public String getSourceAccountNumber() {
        return sourceAccountNumber;
    }

    public String getTargetAccountNumber() {
        return targetAccountNumber;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "TransferRequest{" +
                "sourceAccountNumber='" + sourceAccountNumber + '\'' +
                ", targetAccountNumber='" + targetAccountNumber + '\'' +
                '}';
    }
}
