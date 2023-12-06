package com.openclassrooms.paymybuddy.bo;

import com.openclassrooms.paymybuddy.entities.UserAccount;

import java.math.BigDecimal;

public class TransferBO {

    private UserAccount sender;

    private  UserAccount receiver;

    private  BigDecimal amount;

    private  String description;

    public TransferBO(UserAccount sender, UserAccount receiver, BigDecimal amount, String description) {
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
        this.description = description;
    }

    public TransferBO() {
    }

    public UserAccount getSender() {
        return sender;
    }

    public void setSender(UserAccount sender) {
        this.sender = sender;
    }

    public UserAccount getReceiver() {
        return receiver;
    }

    public void setReceiver(UserAccount receiver) {
        this.receiver = receiver;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
