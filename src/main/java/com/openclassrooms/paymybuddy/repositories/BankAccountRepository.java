package com.openclassrooms.paymybuddy.repositories;

import org.springframework.data.repository.CrudRepository;

import com.openclassrooms.paymybuddy.entities.BankAccount;

public interface BankAccountRepository extends CrudRepository<BankAccount, Long> {
    public BankAccount findById(long id);

}
