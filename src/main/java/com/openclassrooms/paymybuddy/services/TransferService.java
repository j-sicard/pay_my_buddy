package com.openclassrooms.paymybuddy.services;

import com.openclassrooms.paymybuddy.entities.Transfer;
import com.openclassrooms.paymybuddy.entities.UserAccount;

import java.math.BigDecimal;
import java.util.List;

public interface TransferService {
   public boolean createTransfer(UserAccount sender, UserAccount receiver, BigDecimal amount, String description);

   public List<Transfer> getTransfers(UserAccount user);
}
