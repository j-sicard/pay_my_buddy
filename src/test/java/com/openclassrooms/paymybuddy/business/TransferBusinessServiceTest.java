package com.openclassrooms.paymybuddy.business;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.openclassrooms.paymybuddy.AbstractConfigurationTest;
import com.openclassrooms.paymybuddy.repositories.BankAccountRepository;

class TransferBusinessServiceTest extends AbstractConfigurationTest{
	
	@Autowired
	private TransferBusinessService transferBusinessService;
	
	@Autowired
	private BankAccountRepository bankAccountRepository;

	@Test
	void testWithdrawToBankSuccess() {
		assertTrue(transferBusinessService.withdrawAccountToBank(3L, new BigDecimal(50), 5).getBalance().compareTo(new BigDecimal(50)) == 0);
		assertTrue(bankAccountRepository.findById(5L).getBalance().compareTo(new BigDecimal(100)) == 0);
	}
	
	@Test
	void testWithdrawToBankFailure() {
		assertTrue(transferBusinessService.withdrawAccountToBank(4L, new BigDecimal(150), 5).getBalance().compareTo(new BigDecimal(50)) == 0);
		assertTrue(bankAccountRepository.findById(7L).getBalance().compareTo(new BigDecimal(50)) == 0);
	}

	@Test
	void withdrawBankToAccountSuccess(){
		assertTrue(transferBusinessService.withdrawBankToAccount(6L, new BigDecimal(50), 11).getBalance().compareTo(new BigDecimal(150)) == 0);
		assertTrue(bankAccountRepository.findById(11L).getBalance().compareTo(new BigDecimal(50)) == 0);
	}

	@Test
	void withdrawBankToAccountFailure(){
		assertTrue(transferBusinessService.withdrawBankToAccount(7L, new BigDecimal(150), 13).getBalance().compareTo(new BigDecimal(100)) == 0);
		assertTrue(bankAccountRepository.findById(13).getBalance().compareTo(new BigDecimal(100)) == 0);
	}

	@Test
	void  getProfileUserByEmailSuccess(){
		assertTrue(transferBusinessService.getProfileUserByID(8).getFirst_name().compareTo("getProfileUserByEmailSuccess") == 0);
	}
}
