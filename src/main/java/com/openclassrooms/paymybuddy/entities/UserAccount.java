
package com.openclassrooms.paymybuddy.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "user_accounts")
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_account_pk")
    private Integer userAccountID;

    @OneToOne(mappedBy = "userAccount", cascade = CascadeType.ALL)
    private BankAccount bankAccount;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "balance_account")
    private BigDecimal balanceAccount;

    @Column(name = "billing")
    private Integer billing;

    public UserAccount(Integer userAccountID, BankAccount bankAccount, String email, String password, String firstName, String lastName, BigDecimal balanceAccount, Integer billing) {
        this.userAccountID = userAccountID;
        this.bankAccount = bankAccount;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.balanceAccount = balanceAccount;
        this.billing = billing;
    }

    public Integer getUserAccountID() {
        return userAccountID;
    }

    public void setUserAccountID(Integer userAccountID) {
        this.userAccountID = userAccountID;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public BigDecimal getBalanceAccount() {
        return balanceAccount;
    }

    public void setBalanceAccount(BigDecimal balanceAccount) {
        this.balanceAccount = balanceAccount;
    }

    public Integer getBilling() {
        return billing;
    }

    public void setBilling(Integer billing) {
        this.billing = billing;
    }
}

