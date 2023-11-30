package com.openclassrooms.paymybuddy.services;

import com.openclassrooms.paymybuddy.entities.BankAccount;

import java.math.BigDecimal;

public interface BankAccountService {

	public BigDecimal credit(long accountId, BigDecimal amount);

	public BankAccount debit(long accountId, BigDecimal amount);

	public BigDecimal getBalance(long id);

	public BankAccount withdrawForBank(long id, BigDecimal amount);
}
