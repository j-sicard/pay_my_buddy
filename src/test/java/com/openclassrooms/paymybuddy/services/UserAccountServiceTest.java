package com.openclassrooms.paymybuddy.services;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import com.openclassrooms.paymybuddy.calculatetax.CalculateTax;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.openclassrooms.paymybuddy.AbstractConfigurationTest;
import com.openclassrooms.paymybuddy.entities.UserAccount;

class UserAccountServiceTest extends AbstractConfigurationTest{
	
	@Autowired
	private UserAccountService userAccountService;

	@Test
	void testWidthdrawWithUnsufficientBalance() {
		assertTrue(userAccountService.withdraw(1L, new BigDecimal(50)).getBalance().compareTo(new BigDecimal(40)) == 0);
	}
	
	@Test
	void testWidthdrawWithSufficientBalance() {
		assertTrue(userAccountService.withdraw(2L, new BigDecimal(20)).getBalance().compareTo(new BigDecimal(80)) == 0);
	}

	@Test
	void testgetBalance() {
		assertTrue(userAccountService.getBalance(12L).compareTo(new BigDecimal(40)) == 0);
	}

	@Test
	void testGetUserGetEmail(){
		assertTrue(userAccountService.getUser(13L).getEmail().compareTo("testGetUser@test.fr") == 0);
	}

	@Test
	void testGetUserGetEmailGetPassword(){
		assertTrue(userAccountService.getUser(13L).getPassword().compareTo("passwordtestGetUser") == 0);
	}

	@Test
	void testGetUserGetEmailGetFirstName(){
		assertTrue(userAccountService.getUser(13L).getFirstName().compareTo("FirstNametestGetUser") == 0);
	}

	@Test
	void testGetUserGetEmailGetLastName(){
		assertTrue(userAccountService.getUser(13L).getLastName().compareTo("LastNametestGetUser") == 0);
	}

	@Test
	void testGetUserGetEmailGetBalance(){
		assertTrue(userAccountService.getUser(13L).getBalance().compareTo(new BigDecimal(40)) == 0);
	}

	@Test
	void testFindBankAccountsCountBank() {
		assertEquals(2, userAccountService.findBankAccounts(14L).size());
	}

	@Test
	void testCredit(){
		assertEquals(userAccountService.credit( 15L, new BigDecimal(50)), true);
	}

	@Test
	void testCreditFailed(){
		assertEquals(userAccountService.credit( 19L, new BigDecimal(200)), false);
	}

	@Test
	void  testGetUserByEmail(){
		assertTrue(userAccountService.getUserByEmail("testgetUserByEmail@test.fr").getFirstName().compareTo("FirstNamegetUserByEmail") == 0);
	}

	@Test
	void testDebitUserSuccess(){
		assertEquals(userAccountService.debitedUser(20L, new BigDecimal(100)),true);
	}

	@Test
	void testDebitUserFailed(){
		assertEquals(userAccountService.debitedUser(21L, new BigDecimal(500)),false);
	}

	@Test
	void testGetFriends() {
		/*Set<UserAccount> friends = new HashSet<>(22, "testGetFriends@test.fr", "password", "FirstNametest", "LastNametest", 200);*/
	}


}
