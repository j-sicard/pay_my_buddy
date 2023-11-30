package com.openclassrooms.paymybuddy.business;

import java.math.BigDecimal;

import com.openclassrooms.paymybuddy.bo.UserAccountBO;
import com.openclassrooms.paymybuddy.vo.UserVO;

public interface TransferBusinessService {

	public UserAccountBO withdrawAccountToBank(long idUser, BigDecimal amount, long bankAccountId);

	public UserAccountBO withdrawBankToAccount(long idUser, BigDecimal amount, long bankAccountId);

	public UserVO getProfileUserByEmail(long idUser);
}



