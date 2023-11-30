package com.openclassrooms.paymybuddy.business.impl;

import java.math.BigDecimal;

import com.openclassrooms.paymybuddy.entities.BankAccount;
import com.openclassrooms.paymybuddy.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.paymybuddy.business.TransferBusinessService;
import com.openclassrooms.paymybuddy.bo.UserAccountBO;
import com.openclassrooms.paymybuddy.entities.UserAccount;
import com.openclassrooms.paymybuddy.services.BankAccountService;
import com.openclassrooms.paymybuddy.services.UserAccountService;

@Service
public class TransferBusinessServiceImpl implements TransferBusinessService {
	
	@Autowired
	private UserAccountService userAccountService;
	
	@Autowired
	private BankAccountService bankAccountService;
	
	public UserAccountBO withdrawAccountToBank(long idUser, BigDecimal amount, long bankAccountId) {
		BigDecimal balance = userAccountService.getBalance(idUser);
		UserAccount userAccount = userAccountService.withdraw(idUser, amount);
		if(userAccount.getBalance().compareTo(balance) == -1) {
			bankAccountService.credit(bankAccountId, amount);
		}
		return new UserAccountBO(userAccount.getId(), userAccount.getEmail(), userAccount.getFirstName(), userAccount.getLastName(), userAccount.getBalance());
	}
	public UserAccountBO withdrawBankToAccount(long idUser, BigDecimal amount, long bankAccountId) {
		BigDecimal balance = bankAccountService.getBalance(bankAccountId);
		BankAccount bankAccount = bankAccountService.withdrawForBank(bankAccountId, amount);
		if (bankAccount.getBalance().compareTo(balance) == -1) {
			userAccountService.credit(idUser, amount);
		}
		UserAccount userAccount = userAccountService.getUser(idUser);
		return new UserAccountBO(userAccount.getId(), userAccount.getEmail(), userAccount.getFirstName(),
				userAccount.getLastName(), userAccount.getBalance()
		);
	}

	public UserVO getProfileUserByEmail(long idUser){
		UserAccount userAccount = userAccountService.getUser(idUser);
		UserVO userProfile = new UserVO(userAccount.getId(), userAccount.getFirstName(), userAccount.getLastName(), userAccount.getBalance());
		return userProfile;
	};

}
