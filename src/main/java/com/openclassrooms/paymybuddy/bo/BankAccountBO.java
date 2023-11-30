package com.openclassrooms.paymybuddy.bo;

import java.math.BigDecimal;

public class BankAccountBO {
	private long id;

	private String name;

	private BigDecimal balance;

	public BankAccountBO(long id, String name, BigDecimal balance) {
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

}

