package com.openclassrooms.paymybuddy.services.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.paymybuddy.entities.BankAccount;
import com.openclassrooms.paymybuddy.repositories.BankAccountRepository;
import com.openclassrooms.paymybuddy.services.BankAccountService;

@Service
public class BankAccountServiceImpl implements BankAccountService {

	@Autowired
	private BankAccountRepository bankAccountRepository;

	public BigDecimal credit(long accountId, BigDecimal amount) {
		try {
			BankAccount account = bankAccountRepository.findById(accountId);
			account.setBalance(account.getBalance().add(amount));
			bankAccountRepository.save(account);
			return account.getBalance();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Error crediting the bank account.", e);
		}
	}

	@Override
	public BigDecimal getBalance(long id) {
		return bankAccountRepository.findById(id).getBalance();
	}

	public BankAccount withdrawForBank(long bankId, BigDecimal amount) {
		BankAccount bankAccount = bankAccountRepository.findById(bankId);
		BigDecimal balance = bankAccount.getBalance();
		if (balance.compareTo(amount) >= 0) {
			balance = balance.subtract(amount);
			bankAccount.setBalance(balance);
			bankAccountRepository.save(bankAccount);
		}
		return bankAccount;
	}
}
