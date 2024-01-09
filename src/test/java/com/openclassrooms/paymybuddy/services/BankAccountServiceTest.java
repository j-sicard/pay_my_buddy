package com.openclassrooms.paymybuddy.services;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.openclassrooms.paymybuddy.AbstractConfigurationTest;

class BankAccountServiceTest extends AbstractConfigurationTest {
	
	@Autowired
	private BankAccountService bankAccountService;

	@Test
	void testCreditBalance() {
		assertTrue(bankAccountService.credit(9, new BigDecimal(10)).compareTo(new BigDecimal(30)) == 0);
	}

	@Test
	void testgetBalance() {
		assertTrue(bankAccountService.getBalance( 17).compareTo(new BigDecimal(132)) == 0);
	}

	@Test
	void  testWithdrawForBankSuccess(){
		assertTrue(bankAccountService.withdrawForBank(19, new BigDecimal(50)).getBalance().compareTo(new BigDecimal(50)) == 0);
	}

	@Test
	void testWithdrawForBankFailure(){
		assertTrue(bankAccountService.withdrawForBank(21, new BigDecimal(150)).getBalance().compareTo(new BigDecimal(100)) == 0);
	}
}
