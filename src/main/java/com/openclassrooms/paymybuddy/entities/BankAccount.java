package com.openclassrooms.paymybuddy.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bank_accounts")
public class BankAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column()
	private long id;

	@Column()
	private String name;

	@Column()
	private BigDecimal balance;

	@ManyToOne()
	@JoinColumn(name = "id_user_account")
	private UserAccount userAccount;

	public BankAccount() {

	}

	public BankAccount(long id, String name, BigDecimal balance) {
		super();
		this.id = id;
		this.name = name;
		this.balance = balance;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public UserAccount getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}
}

