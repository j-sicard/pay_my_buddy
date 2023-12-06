package com.openclassrooms.paymybuddy.controllers;

import com.openclassrooms.paymybuddy.business.UserFriendBusinessService;
import com.openclassrooms.paymybuddy.entities.UserAccount;
import com.openclassrooms.paymybuddy.fo.FriendFO;
import com.openclassrooms.paymybuddy.fo.UserToUserTranferFO;
import com.openclassrooms.paymybuddy.services.UserAccountService;
import com.openclassrooms.paymybuddy.vo.FriendVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

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

    @GetMapping("/friend/{userID}")
    public List<FriendVO> getfriends(@PathVariable long userID){
        return userFriendBusinessService.getAllFriends(userID);
    }


    @PostMapping("/paymybuddy")
    public String payMyBuddy(@RequestBody UserToUserTranferFO userToUserTranferFO){
          return userFriendBusinessService.debitAccount(userToUserTranferFO.getSenderID(), userToUserTranferFO.getReceiverID(),
                  userToUserTranferFO.getAmount(), userToUserTranferFO.getDescription());
    }

}
