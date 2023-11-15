package com.openclassrooms.paymybuddy.controllers;

import com.openclassrooms.paymybuddy.entities.UserAccount;
import com.openclassrooms.paymybuddy.services.UserInformationManagementService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class ProfilePageController {

    @Autowired
    UserInformationManagementService userService;

    @GetMapping(path = "profile/{id}")
    public String getUserInformation(@PathVariable int id, Model model) {
        Optional<UserAccount> userOptional = userService.retrievalUserInformationById(id);

        if (userOptional.isPresent()) {
            UserAccount user = userOptional.get();

            // Vérifier que les propriétés nécessaires ne sont pas nulles avant de les ajouter au modèle
            if (user.getFirstName() != null && user.getLastName() != null && user.getBalanceAccount() != null && user.getEmail() != null) {
                model.addAttribute("user", user);
                return "profile";
            } else {
                return "userNotFound";
            }
        } else {
            return "userNotFound";
        }
    }


}
