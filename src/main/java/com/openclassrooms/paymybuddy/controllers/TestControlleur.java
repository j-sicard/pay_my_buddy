package com.openclassrooms.paymybuddy.controllers;

import com.openclassrooms.paymybuddy.entities.UserAccount;
import com.openclassrooms.paymybuddy.services.BankAccountManagementService;
import com.openclassrooms.paymybuddy.services.CalculationManageService;
import com.openclassrooms.paymybuddy.services.UserInformationManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Map;


@RestController
public class TestControlleur {

    @Autowired
    UserInformationManagementService userInformationManagementService;

    @Autowired
    BankAccountManagementService bankAccountManagementService;

    @Autowired
    CalculationManageService calculationManageService;


    @GetMapping(value = "/allusers")
    public Iterable<UserAccount> getAllUserInformation() {
        Iterable<UserAccount> users = userInformationManagementService.getAllUserAccount();

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
        return userInformationManagementService.getBalanceAccountByEmail(email);
    }

    @PutMapping("/bank/{email}")
    public ResponseEntity<String> updateBank(@PathVariable String email) {
        Map<String, Integer> newSoldes = calculationManageService.debitCreditmanagement(
                bankAccountManagementService.getBalanceAccountByEmail(email),
                userInformationManagementService.getBalanceAccountByEmail(email),
                100
        );

        String result = calculationManageService.saveAmountAfterDebited(newSoldes, email);

        if ("Amount saved successfully".equals(result)) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.status(500).body(result); // Adjust the status code and message as needed
        }
    }

    @PutMapping(value = "/testup/{email}")
    public void updateuser(@PathVariable String email) {
        userInformationManagementService.updateBalanceUserByEmail(500, email);
    }

    @PutMapping(value = "/testdown/{email}/{solde}")
    public void updatebank(@PathVariable String email, @PathVariable BigDecimal solde) {
        bankAccountManagementService.updtadeBalanceAccountBankByEmail(solde, String.valueOf(email));
    }



}

