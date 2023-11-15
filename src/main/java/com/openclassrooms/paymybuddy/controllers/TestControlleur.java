package com.openclassrooms.paymybuddy.controllers;

import com.openclassrooms.paymybuddy.entities.UserAccount;
import com.openclassrooms.paymybuddy.services.UserInformationManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestControlleur {

    @Autowired
    UserInformationManagementService userService;


    @GetMapping(value = "/allusers")
    public Iterable<UserAccount> getAllUserInformation() {
        Iterable<UserAccount> users = userService.getAllUserAccount();

        if (users != null) {
            System.out.println("Utilisateurs trouvés : " + users);
            return users;
        } else {
            System.out.println("Utilisateurs non trouvés.");
            return null;
        }
    }


    @GetMapping(value = "/test/{email}")
    public Integer getInformation(@PathVariable String email) {
        return userService.getBalanceAccountByEmail(email);
    }


}
