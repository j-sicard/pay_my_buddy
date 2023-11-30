package com.openclassrooms.paymybuddy.controllers;

import java.util.List;

import com.openclassrooms.paymybuddy.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.openclassrooms.paymybuddy.business.TransferBusinessService;
import com.openclassrooms.paymybuddy.bo.BankAccountBO;
import com.openclassrooms.paymybuddy.bo.UserAccountBO;
import com.openclassrooms.paymybuddy.fo.WithdrawInfoFO;
import com.openclassrooms.paymybuddy.services.UserAccountService;

@RestController
@RequestMapping("/accounts")
@CrossOrigin(origins = "http://localhost:3000")
public class UserAccountController {
	
	@Autowired
	private TransferBusinessService transferBusinessService;
	
	@Autowired
	private UserAccountService userAccountService;

	@PostMapping("/withdraw")
	public UserAccountBO withdrawAccountToBank(@RequestBody WithdrawInfoFO withdrawInfo) {
		return transferBusinessService.withdrawAccountToBank(withdrawInfo.getUserId(),
				withdrawInfo.getAmount(), withdrawInfo.getBankAccountId());
	}

	
	@GetMapping("/{id}/banks")
	public List<BankAccountBO> listBankAccounts(@PathVariable("id") long id) {
		return userAccountService.findBankAccounts(id);
	}

	@PostMapping("/enhanced")
	public UserAccountBO EnhancedAccountByBank(@RequestBody WithdrawInfoFO withdrawInfoFO){
		return transferBusinessService.withdrawBankToAccount(withdrawInfoFO.getUserId(),
				withdrawInfoFO.getAmount(), withdrawInfoFO.getBankAccountId());
	}

	@GetMapping("{id}/user")
	public UserVO profileUser(@PathVariable("id")long id) {
		return   transferBusinessService.getProfileUserByEmail(id);
	}
}

