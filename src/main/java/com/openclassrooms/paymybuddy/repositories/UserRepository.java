package com.openclassrooms.paymybuddy.repositories;

import com.openclassrooms.paymybuddy.entities.UserAccount;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserRepository  extends CrudRepository<UserAccount, Integer> {

    @Query("SELECT u.balanceAccount FROM UserAccount u WHERE u.email = :email")
    Integer findBalanceAccountByEmail(@Param("email") String email);

    @Modifying
    @Query("UPDATE UserAccount u SET u.balanceAccount = :newBalance WHERE u.email = :email")
    void updateBalanceByUserEmail(@Param("email") String email, @Param("newBalance") Integer newBalance);

}

