package com.openclassrooms.paymybuddy.repositories;

import com.openclassrooms.paymybuddy.entities.Transfer;
import org.springframework.data.repository.CrudRepository;

public interface TransferRepository extends CrudRepository<Transfer, Long> {
}
