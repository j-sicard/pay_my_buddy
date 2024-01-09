package com.openclassrooms.paymybuddy.controllers;

import com.openclassrooms.paymybuddy.business.UserFriendBusinessService;
import com.openclassrooms.paymybuddy.entities.Transfer;
import com.openclassrooms.paymybuddy.fo.FriendFO;
import com.openclassrooms.paymybuddy.fo.UserToUserTranferFO;
import com.openclassrooms.paymybuddy.vo.FriendVO;
import com.openclassrooms.paymybuddy.vo.TransferVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/transfers")
@CrossOrigin(origins = "http://localhost:3000")
public class TransferController {


    @Autowired
    UserFriendBusinessService userFriendBusinessService;


   @PostMapping("/addFriend")
    public String addFriendList(@RequestBody FriendFO friendFO){
       System.out.println("Received request: " + friendFO.toString());
        return userFriendBusinessService.addNewFriend(friendFO.getUserID(), friendFO.getFriendEmail());
    }


    @GetMapping("/friend/{userID}")
    public List<FriendVO> getfriends(@PathVariable long userID){
        return userFriendBusinessService.getAllFriends(userID);
    }


    @PostMapping("/paymybuddy")
    public ResponseEntity<Map<String, String>> payMyBuddy(@RequestBody UserToUserTranferFO userToUserTranferFO) {
        try {
            String result = userFriendBusinessService.transferMoneyUserAtUser(
                    userToUserTranferFO.getSenderID(),
                    userToUserTranferFO.getReceiverID(),
                    userToUserTranferFO.getAmount(),
                    userToUserTranferFO.getDescription()
            );
            Map<String, String> response = new HashMap<>();
            response.put("message", result);

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.singletonMap("error", "An error occurred during the operation."));
        }
    }


    @GetMapping("/history/{userID}")
    public List<TransferVO> getHistoryTransfers(@PathVariable long userID){
       return userFriendBusinessService.findAllTransferByUserID(userID);
   }
}
