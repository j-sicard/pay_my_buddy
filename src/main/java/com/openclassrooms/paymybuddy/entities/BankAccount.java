package com.openclassrooms.paymybuddy.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "bank_accounts")
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bank_account_pk")
    private Integer bankAccountID;

    @OneToOne
    @JoinColumn(name = "account_fk", referencedColumnName = "user_account_pk")
    private UserAccount userAccount;

    @Column(name = "bank_name")
    private String bankName;

    @Column(name = "account_number")
    private BigDecimal accountNumber;

    @Column(name = "balance_account")
    private BigDecimal balanceAccount;

    public BankAccount(Integer bankAccountID, UserAccount userAccount, String bankName, BigDecimal accountNumber, BigDecimal balanceAccount) {
        this.bankAccountID = bankAccountID;
        this.userAccount = userAccount;
        this.bankName = bankName;
        this.accountNumber = accountNumber;
        this.balanceAccount = balanceAccount;
    }

    public Integer getBankAccountID() {
        return bankAccountID;
    }

    public void setBankAccountID(Integer bankAccountID) {
        this.bankAccountID = bankAccountID;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public BigDecimal getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(BigDecimal accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getBalanceAccount() {
        return balanceAccount;
    }

    public void setBalanceAccount(BigDecimal balanceAccount) {
        this.balanceAccount = balanceAccount;
    }
}
