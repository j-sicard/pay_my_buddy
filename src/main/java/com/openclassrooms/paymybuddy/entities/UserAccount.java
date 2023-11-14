
package com.openclassrooms.paymybuddy.entities;

import javax.persistence.*;

@Entity
@Table(name = "user_accounts")
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_account_pk")
    private Integer userAccountID;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "balance_account")
    private Integer balanceAccount;

    @Column(name = "billing")
    private Integer billing;

    public UserAccount(Integer userAccountID, String email, String password, String firstName, String lastName, Integer balanceAccount, Integer billing) {
        this.userAccountID = userAccountID;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.balanceAccount = balanceAccount;
        this.billing = billing;
    }

    public UserAccount(){}

    public Integer getUserAccountID() {
        return userAccountID;
    }

    public void setUserAccountID(Integer userAccountID) {
        this.userAccountID = userAccountID;
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

    public Integer getBalanceAccount() {
        return balanceAccount;
    }

    public void setBalanceAccount(Integer balanceAccount) {
        this.balanceAccount = balanceAccount;
    }

    public Integer getBilling() {
        return billing;
    }

    public void setBilling(Integer billing) {
        this.billing = billing;
    }
}

