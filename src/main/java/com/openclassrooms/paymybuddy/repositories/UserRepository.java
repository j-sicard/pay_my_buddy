package com.openclassrooms.paymybuddy.repositories;

import com.openclassrooms.paymybuddy.entities.UserAccount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends CrudRepository<UserAccount, Integer> {

    @Query("SELECT u.balanceAccount FROM UserAccount u WHERE u.email = :email")
    Integer findBalanceAccountByEmail(@Param("email") String email);


}
