package com.openclassrooms.paymybuddy.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.openclassrooms.paymybuddy.entities.UserAccount;

@Repository
public interface UserAccountRepository  extends CrudRepository<UserAccount, Long> {
	
	public UserAccount findByEmail(String email);

}

