package com.openclassrooms.paymybuddy.vo;

import java.math.BigDecimal;

public class TransferVO {

    private long id;

    private String receiverFirstName;

    private BigDecimal amount;

    private String description;

    public TransferVO(long id, String receiverFirstName, BigDecimal amount, String description) {
        this.id = id;
        this.receiverFirstName = receiverFirstName;
        this.amount = amount;
        this.description = description;
    }

    public TransferVO() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getReceiverFirstName() {
        return receiverFirstName;
    }

    public void setReceiverFirstName(String receiverFirstName) {
        this.receiverFirstName = receiverFirstName;
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
