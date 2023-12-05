package com.openclassrooms.paymybuddy.controllers;

import com.openclassrooms.paymybuddy.business.TransferBusinessService;
import com.openclassrooms.paymybuddy.business.UserFriendBusinessService;
import com.openclassrooms.paymybuddy.entities.UserAccount;
import com.openclassrooms.paymybuddy.fo.FriendFO;
import com.openclassrooms.paymybuddy.fo.FriendTransferFO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/transfers")
@CrossOrigin(origins = "http://localhost:3000")
public class TransferController {


    @Autowired
    UserFriendBusinessService userFriendBusinessService;

    @PostMapping("/addFriend")
    public String addFriendList(@RequestBody FriendFO friendFO){
        return userFriendBusinessService.addNewFriend(friendFO.getUserID(), friendFO.getFriendEmail());
    }

    @GetMapping("/friend/{userID}/{friendID}")
    public UserAccount getfriend(@PathVariable long userID, @PathVariable long friendID){
        return userFriendBusinessService.getFriendByID(userID, friendID);
    }


    @PostMapping("/paymybuddy")
    public UserAccount payMyBuddy(@RequestBody FriendTransferFO friendTransferFO){
          return userFriendBusinessService.debitAccount(friendTransferFO.getUserID(), friendTransferFO.getFriendID(), friendTransferFO.getAmount());
    }

}
