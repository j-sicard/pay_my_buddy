package com.openclassrooms.paymybuddy.repositories;

import com.openclassrooms.paymybuddy.entities.UserAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends CrudRepository<UserAccount, Integer> {

}
