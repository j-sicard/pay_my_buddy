package com.openclassrooms.paymybuddy.entities;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "transfers")
public class Transfer{


   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "transfer_id")
   private long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userId", nullable = false)
    private UserAccount user;

    @Column
    private String receiverFirstName;

    @Column
    private String description;

    @Column
    private BigDecimal amount;

    @Column
    private  BigDecimal costs;

    public Transfer(long id, UserAccount user, String receiverFirstName, String description, BigDecimal amount, BigDecimal costs) {
        this.id = id;
        this.user = user;
        this.receiverFirstName = receiverFirstName;
        this.description = description;
        this.amount = amount;
        this.costs = costs;
    }

    public Transfer() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UserAccount getUser() {
        return user;
    }

    public void setUser(UserAccount user) {
        this.user = user;
    }

    public String getReceiverFirstName() {
        return receiverFirstName;
    }

    public void setReceiverFirstName(String receiverFirstName) {
        this.receiverFirstName = receiverFirstName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getCosts() {
        return costs;
    }

    public void setCosts(BigDecimal costs) {
        this.costs = costs;
    }
}