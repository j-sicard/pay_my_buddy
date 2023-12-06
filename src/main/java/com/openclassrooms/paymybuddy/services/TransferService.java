package com.openclassrooms.paymybuddy.services;

import com.openclassrooms.paymybuddy.entities.UserAccount;

import java.math.BigDecimal;

public interface TransferService {
    public boolean createTransfer(UserAccount sender, UserAccount receiver, BigDecimal amount, String description);
}
