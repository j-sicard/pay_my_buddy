package com.openclassrooms.paymybuddy.business;

import java.math.BigDecimal;
import java.util.List;

import com.openclassrooms.paymybuddy.bo.BankAccountBO;
import com.openclassrooms.paymybuddy.bo.UserAccountBO;
import com.openclassrooms.paymybuddy.entities.UserAccount;
import com.openclassrooms.paymybuddy.vo.UserVO;

public interface TransferBusinessService {

	public UserAccountBO withdrawAccountToBank(long idUser, BigDecimal amount, long bankAccountId);

	public UserAccountBO withdrawBankToAccount(long idUser, BigDecimal amount, long bankAccountId);

	public UserVO getProfileUserByID(long idUser);

	public long getuserIDbyEmail(String email);

	public String registerUser(String email, String password);

	public List<BankAccountBO> getbankAccountById(long id);

}



