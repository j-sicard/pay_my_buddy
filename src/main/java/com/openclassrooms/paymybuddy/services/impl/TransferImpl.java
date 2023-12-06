package com.openclassrooms.paymybuddy.services.impl;

import com.openclassrooms.paymybuddy.entities.Transfer;
import com.openclassrooms.paymybuddy.entities.UserAccount;
import com.openclassrooms.paymybuddy.repositories.TransferRepository;
import com.openclassrooms.paymybuddy.repositories.UserAccountRepository;
import com.openclassrooms.paymybuddy.services.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service
public class TransferImpl implements TransferService {

    @Autowired
    TransferRepository transferRepository;

    @Autowired
    UserAccountRepository userAccountRepository;

    public boolean createTransfer(UserAccount sender, UserAccount receiver, BigDecimal amount, String description) {
        try {
            Transfer transfer = new Transfer();
            transfer.setSender(sender);
            transfer.setReceiver(receiver);
            transfer.setAmount(amount);
            transfer.setDescription(description);

            transferRepository.save(transfer);

            sender.getTransferRecipients().add(receiver);
            receiver.getTransferSenders().add(sender);

            userAccountRepository.save(sender);
            userAccountRepository.save(receiver);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }



}
