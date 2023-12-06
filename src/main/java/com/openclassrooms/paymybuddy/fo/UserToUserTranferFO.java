package com.openclassrooms.paymybuddy.fo;

import java.math.BigDecimal;

public class UserToUserTranferFO {

    private long senderID;

    private  long receiverID;

    private BigDecimal amount;

    private String  description;

    public UserToUserTranferFO(long userID, long friendID, BigDecimal amount, String description) {
        this.senderID = userID;
        this.receiverID = friendID;
        this.amount = amount;
        this.description = description;
    }

    public long getSenderID() {
        return senderID;
    }

    public void setSenderID(long senderID) {
        this.senderID = senderID;
    }

    public long getReceiverID() {
        return receiverID;
    }

    public void setReceiverID(long receiverID) {
        this.receiverID = receiverID;
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
