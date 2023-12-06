package com.openclassrooms.paymybuddy.entities;


import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "transfers")
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column()
    private long id;

    @ManyToOne
    @JoinColumn(name = "sender_user_account_id")
    private UserAccount sender;

    @ManyToOne
    @JoinColumn(name = "receiver_user_account_id")
    private UserAccount receiver;

    @Column
    private String description;

    @Column
    private BigDecimal amount;

    public Transfer(long id, UserAccount sender, UserAccount receiver, String description, BigDecimal amount) {
        this.id = id;
        this.sender = sender;
        this.receiver = receiver;
        this.description = description;
        this.amount = amount;
    }

    public Transfer() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
}
