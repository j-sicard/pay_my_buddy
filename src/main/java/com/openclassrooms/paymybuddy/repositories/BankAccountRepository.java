package com.openclassrooms.paymybuddy.repositories;

import com.openclassrooms.paymybuddy.entities.BankAccount;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;

public interface BankAccountRepository extends CrudRepository<BankAccount, Integer> {

    @Query("SELECT ba.balanceAccount FROM BankAccount ba WHERE ba.userAccount.email = :email")
    Integer findBalanceAccountByEmail(@Param("email") String email);

    @Modifying
    @Query("UPDATE BankAccount ba SET ba.balanceAccount = :newBalance WHERE ba.userAccount.email = :email")
    void updateBalanceByUserEmail(@Param("newBalance") BigDecimal newBalance, @Param("email") String email);


}
