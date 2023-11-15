package com.openclassrooms.paymybuddy.services;

import com.openclassrooms.paymybuddy.entities.UserAccount;
import com.openclassrooms.paymybuddy.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserInformationManagementService {
    @Autowired
    private UserRepository userRepository;

    public Optional<UserAccount> retrievalUserInformationById(int id) {
        return userRepository.findById(id);
    }

    public Iterable<UserAccount> getAllUserAccount(){
        return userRepository.findAll();
    }


    public Integer getBalanceAccountByEmail(String email){
        return userRepository.findBalanceAccountByEmail(email);
    }
}
