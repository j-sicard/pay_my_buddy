package com.openclassrooms.paymybuddy.services;

import com.openclassrooms.paymybuddy.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;

@Service
public class BankAccountManagementService {

    @Autowired
    BankAccountRepository bankAccountRepository;

    public Integer getBalanceAccountByEmail(String email){
        return bankAccountRepository.findBalanceAccountByEmail(email);
    }

    @Transactional
    public void updtadeBalanceAccountBankByEmail(BigDecimal newBalance, String email) {
        bankAccountRepository.updateBalanceByUserEmail(newBalance, email);
    }

}
