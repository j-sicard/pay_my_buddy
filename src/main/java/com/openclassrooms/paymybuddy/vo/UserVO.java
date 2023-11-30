package com.openclassrooms.paymybuddy.vo;

import java.math.BigDecimal;

public class UserVO {
    private long id;
    private String first_name;
    private  String last_name;
    private BigDecimal balance;

    public UserVO(long id, String first_name, String last_name, BigDecimal balance) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.balance = balance;
    }

    public UserVO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}

