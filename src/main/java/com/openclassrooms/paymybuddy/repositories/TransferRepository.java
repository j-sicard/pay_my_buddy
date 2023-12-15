package com.openclassrooms.paymybuddy.repositories;

import com.openclassrooms.paymybuddy.entities.Transfer;
import com.openclassrooms.paymybuddy.entities.UserAccount;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TransferRepository extends CrudRepository<Transfer, Long> {

    List<Transfer> findByUser(UserAccount user);
}
