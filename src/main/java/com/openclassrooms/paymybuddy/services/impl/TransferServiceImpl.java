package com.openclassrooms.paymybuddy.services.impl;

import com.openclassrooms.paymybuddy.entities.Transfer;
import com.openclassrooms.paymybuddy.entities.UserAccount;
import com.openclassrooms.paymybuddy.repositories.TransferRepository;
import com.openclassrooms.paymybuddy.repositories.UserAccountRepository;
import com.openclassrooms.paymybuddy.services.TransferService;
import com.openclassrooms.paymybuddy.calculatetax.CalculateTax;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;


@Service
public class TransferServiceImpl implements TransferService {

    @Autowired
    TransferRepository transferRepository;

    @Autowired
    UserAccountRepository userAccountRepository;



    public boolean createTransfer(UserAccount sender, UserAccount receiver, BigDecimal amount, String description) {
        try {
            BigDecimal costs = CalculateTax.calculCost(amount);

            Transfer transfer = new Transfer();
            transfer.setUser(sender);
            transfer.setReceiverFirstName(receiver.getFirstName());
            transfer.setDescription(description);
            transfer.setAmount(amount);
            transfer.setCosts(costs);

            transferRepository.save(transfer);

            sender.getTransactions().add(transfer);
            receiver.getTransactions().add(transfer);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Transfer> getTransfers(UserAccount user){
        return transferRepository.findByUser(user);
    }

}





