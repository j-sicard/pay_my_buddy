package com.openclassrooms.paymybuddy.services.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.paymybuddy.bo.BankAccountBO;
import com.openclassrooms.paymybuddy.entities.UserAccount;
import com.openclassrooms.paymybuddy.repositories.UserAccountRepository;
import com.openclassrooms.paymybuddy.services.UserAccountService;

@Service
public class UserAccountServiceImpl implements UserAccountService {

	@Autowired
	private UserAccountRepository userAccountRepository;

	public UserAccount withdraw(Long idUser, BigDecimal amount) {
		UserAccount userAccount = userAccountRepository.findById(idUser).get();
		BigDecimal balance = userAccount.getBalance();
		if(balance.compareTo(amount) >= 0 ) {
			balance = balance.subtract(amount);
			userAccount.setBalance(balance);
			userAccountRepository.save(userAccount);
		}
		return userAccount;
	}

	@Override
	public BigDecimal getBalance(long idUser) {
		return userAccountRepository.findById(idUser).get().getBalance();
	}


	@Override
	public UserAccount getUser(long idUser) {
		return userAccountRepository.findById(idUser).get();
	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public List<BankAccountBO> findBankAccounts(long id) {
		return userAccountRepository.findById(id).get().getBankAccounts().stream().map
				(o -> new BankAccountBO(o.getId(), o.getName(), o.getBalance())).collect(Collectors.toList());
	}

	public boolean credit(long idUser, BigDecimal amount) {
		try {
			UserAccount account = userAccountRepository.findById(idUser).orElseThrow(() -> new NoSuchElementException("User not found"));
			account.setBalance(account.getBalance().add(amount));
			userAccountRepository.save(account);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}


	@Override
	public UserAccount getUserByEmail(String email){
		return userAccountRepository.findByEmail(email);
	}


	@Override
	public Set<UserAccount> getFriends(long userId){
		return  userAccountRepository.findById(userId).get().getFriends();
	}

	public UserAccount getFriendWithID(long userID, long friendID){
		for (UserAccount friend : userAccountRepository.findById(userID).get().getFriends()) {
			if (Objects.equals(friend.getId(), friendID)){
				return friend;
			}
		}
		return null;
	}

	public boolean debitedUser(Long idUser, BigDecimal amount) {
		try {
			UserAccount userAccount = userAccountRepository.findById(idUser).orElseThrow(() -> new NoSuchElementException("User not found"));

			BigDecimal balance = userAccount.getBalance();
			balance = balance.subtract(amount);
			userAccount.setBalance(balance);

			userAccountRepository.save(userAccount);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public void saveUser(UserAccount userAccount){
		userAccountRepository.save(userAccount);
	}

}
