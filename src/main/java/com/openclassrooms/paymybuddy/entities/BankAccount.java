package com.openclassrooms.paymybuddy.entities;

import javax.persistence.*;

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
    private Integer accountNumber;

    @Column(name = "balance_account")
    private Integer balanceAccount;

    public BankAccount(Integer bankAccountID, UserAccount userAccount, String bankName, Integer accountNumber, Integer balanceAccount) {
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

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Integer getBalanceAccount() {
        return balanceAccount;
    }

    public void setBalanceAccount(Integer balanceAccount) {
        this.balanceAccount = balanceAccount;
    }
}
