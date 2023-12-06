package com.openclassrooms.paymybuddy.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import com.openclassrooms.paymybuddy.bo.BankAccountBO;
import com.openclassrooms.paymybuddy.entities.UserAccount;

public interface UserAccountService {

	public UserAccount withdraw(Long idUser, BigDecimal amount);

	public BigDecimal getBalance(long idUser);

	public UserAccount getUser(long idUser);

	public List<BankAccountBO> findBankAccounts(long id);

	public boolean credit(long idUser, BigDecimal amount);

	public Set<UserAccount> getFriends(long userId);

	public UserAccount getUserByEmail(String email);

	public UserAccount getFriendWithID(long userID, long friendID);

	public boolean debitedUser(Long idUser, BigDecimal amount);

}

