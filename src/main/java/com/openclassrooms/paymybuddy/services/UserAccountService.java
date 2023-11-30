package com.openclassrooms.paymybuddy.services;

import java.math.BigDecimal;
import java.util.List;

import com.openclassrooms.paymybuddy.bo.BankAccountBO;
import com.openclassrooms.paymybuddy.entities.UserAccount;

public interface UserAccountService {

	public UserAccount withdraw(Long idUser, BigDecimal amount);

	public BigDecimal getBalance(long idUser);

	public UserAccount getUser(long idUser);

	public List<BankAccountBO> findBankAccounts(long id);

	public  BigDecimal credit(long idUser, BigDecimal amount);
}

