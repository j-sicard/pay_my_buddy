package com.openclassrooms.paymybuddy.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "friend_accounts")
public class FriendAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column()
    private  long id;

    @Column
    private String email;

    @Column
    private BigDecimal amount;

    @ManyToMany(mappedBy = "friends")
    private Set<UserAccount> users = new HashSet<>();


    public FriendAccount(long id, String email, BigDecimal amount, Set<UserAccount> users) {
        this.id = id;
        this.email = email;
        this.amount = amount;
        this.users = users;
    }

    public FriendAccount() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Set<UserAccount> getUsers() {
        return users;
    }

    public void setUsers(Set<UserAccount> users) {
        this.users = users;
    }
}
