package com.openclassrooms.paymybuddy.fo;

import java.io.Serializable;
import java.math.BigDecimal;

public class WithdrawInfoFO implements Serializable {

	/**
	 * UUID
	 */
	private static final long serialVersionUID = 8623344624769899493L;

	private long userId;

	private BigDecimal amount;

	private long bankAccountId;

	public WithdrawInfoFO(long userId, BigDecimal amount, long bankAccountId) {
		this.userId = userId;
		this.amount = amount;
		this.bankAccountId = bankAccountId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public long getBankAccountId() {
		return bankAccountId;
	}

	public void setBankAccountId(long bankAccountId) {
		this.bankAccountId = bankAccountId;
	}
}
