package com.openclassrooms.paymybuddy.business.impl;

import java.math.BigDecimal;
import java.util.List;

import com.openclassrooms.paymybuddy.bo.BankAccountBO;
import com.openclassrooms.paymybuddy.entities.BankAccount;
import com.openclassrooms.paymybuddy.repositories.UserAccountRepository;
import com.openclassrooms.paymybuddy.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.paymybuddy.business.TransferBusinessService;
import com.openclassrooms.paymybuddy.bo.UserAccountBO;
import com.openclassrooms.paymybuddy.entities.UserAccount;
import com.openclassrooms.paymybuddy.services.BankAccountService;
import com.openclassrooms.paymybuddy.services.UserAccountService;

import javax.transaction.Transactional;

@Service
public class TransferBusinessServiceImpl implements TransferBusinessService {
	
	@Autowired
	private UserAccountService userAccountService;
	
	@Autowired
	private BankAccountService bankAccountService;

	@Transactional
	public UserAccountBO withdrawAccountToBank(long idUser, BigDecimal amount, long bankAccountId) {
		try {
			BigDecimal balance = userAccountService.getBalance(idUser);
			UserAccount userAccount = userAccountService.withdraw(idUser, amount);

			if (userAccount.getBalance().compareTo(balance) < 0) {
				bankAccountService.credit(bankAccountId, amount);
			}
			return new UserAccountBO(userAccount.getId(), userAccount.getEmail(), userAccount.getFirstName(), userAccount.getLastName(), userAccount.getBalance());
		} catch (Exception e) {
			throw new RuntimeException("Withdrawal operation failed", e);
		}
	}
	@Transactional
	public UserAccountBO withdrawBankToAccount(long idUser, BigDecimal amount, long bankAccountId) {
		try {
			BigDecimal balance = bankAccountService.getBalance(bankAccountId);
			BankAccount bankAccount = bankAccountService.withdrawForBank(bankAccountId, amount);

			if (bankAccount.getBalance().compareTo(balance) < 0) {
				userAccountService.credit(idUser, amount);
			}
			UserAccount userAccount = userAccountService.getUser(idUser);
			return new UserAccountBO(
					userAccount.getId(),
					userAccount.getEmail(),
					userAccount.getFirstName(),
					userAccount.getLastName(),
					userAccount.getBalance()
			);
		} catch (Exception e) {
			throw new RuntimeException("An error occurred while transferring money.", e);
		}
	}


	public UserVO getProfileUserByID(long idUser){
		UserAccount userAccount = userAccountService.getUser(idUser);
		UserVO userProfile = new UserVO(userAccount.getId(), userAccount.getFirstName(), userAccount.getLastName(), userAccount.getBalance());
		return userProfile;
	};


	public long getuserIDbyEmail(String email){
		return userAccountService.getUserByEmail(email).getId();
	}

	public String registerUser(String email, String password) {
		try {
			List<String> allEmails = userAccountService.getAllEmail();

			if (!allEmails.contains(email)) {
				userAccountService.registerUser(email, password);
				return "User registered successfully!";
			} else {
				return "Email already exists. Please choose a different email.";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "An error occurred while registering the user.";
		}
	}

	public  List<BankAccountBO> getbankAccountById(long id){
		return userAccountService.findBankAccounts(id);
	}

}
