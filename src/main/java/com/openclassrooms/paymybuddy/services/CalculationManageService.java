package com.openclassrooms.paymybuddy.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class CalculationManageService {

    @Autowired
    UserInformationManagementService userInformationManagementService;

    @Autowired
    BankAccountManagementService bankAccountManagementService;

    public static Integer subtractionOperation(int a, int b){
        return a - b;
    }

    public static Integer additionOperation(int solde, int amountCredited ){
        return solde + amountCredited;
    }

    public static Map<String, Integer> createBalanceMap(int debitedAccount, int creditedAccount){
        Map<String, Integer> newSoldes = new HashMap<>();
        newSoldes.put("debitedAccount", debitedAccount);
        newSoldes.put("creditedAccount", creditedAccount);
        return newSoldes;
    }

    public  Map<String, Integer> debitCreditmanagement(int debitedAccount, int creditedAccount, int amountTransfer) {
       Map<String, Integer> newSoldes = new HashMap<>();
        if (debitedAccount >= amountTransfer && amountTransfer > 0) {
            newSoldes =  createBalanceMap(subtractionOperation(debitedAccount, amountTransfer), additionOperation(creditedAccount,amountTransfer));
        } else {
            System.out.println("the operation failed, a problem occurred.");
        }
        System.out.println("Debug - creditedAccount: " + creditedAccount);
        System.out.println("Debug - debitedAccount: " + debitedAccount);
        System.out.println("Debug - newSoldes: " + newSoldes);
        return newSoldes;
    }

    public String saveAmountAfterDebited(Map<String, Integer> newSoldes, String email) {
        try {
            if (!newSoldes.isEmpty()) {
                userInformationManagementService.updateBalanceUserByEmail(newSoldes.get("creditedAccount"), email);
                /*bankAccountManagementService.updtadeBalanceAccountBankByEmail(newSoldes.get("debitedAccount"), email);*/
                System.out.println("Operation carried out successfully");
                return "Amount saved successfully";
            } else {
                System.out.println("An issue occurred: newSoldes is empty");
                return "An issue occurred: newSoldes is empty";
            }
        } catch (Exception e) {
            System.out.println("An issue occurred: " + e.getMessage());
            e.printStackTrace();
            return "An issue occurred: " + e.getMessage();
        }
    }

}
