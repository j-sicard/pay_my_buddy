package com.openclassrooms.paymybuddy.business.impl;

import com.openclassrooms.paymybuddy.entities.UserAccount;
import com.openclassrooms.paymybuddy.business.UserFriendBusinessService;
import com.openclassrooms.paymybuddy.services.TransferService;
import com.openclassrooms.paymybuddy.services.UserAccountService;
import com.openclassrooms.paymybuddy.vo.FriendVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.SecondaryTable;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class UserFriendBusinessServiceImpl implements UserFriendBusinessService {

    @Autowired
    UserAccountService userAccountService;

    @Autowired
    TransferService transferService;




    public String addNewFriend(long userId, String friendEmail){
        UserAccount user = userAccountService.getUser(userId);
        UserAccount friend = userAccountService.getUserByEmail(friendEmail);
        if (userId != friend.getId() && !user.getFriends().contains(friend)){
              user.getFriends().add(friend);
              return "user " + friend.getFirstName() + " has been registered";
          }
          return "An error has occured";
    }


    public  UserAccount getFriendByID(long userID, long friendID){
        return userAccountService.getFriendWithID(userID, friendID);
    }

    @Transactional
    @Override
    public String debitAccount(long senderID, long receiverID, BigDecimal amount, String description) {
        UserAccount sender = userAccountService.getUser(senderID);
        UserAccount receiver = userAccountService.getUser(receiverID);

    if (sender.getBalance().compareTo(amount) >= 0) {
            userAccountService.debitedUser(senderID, amount);
            userAccountService.credit(userAccountService.getFriendWithID(senderID, receiverID).getId(), amount);
            transferService.createTransfer(sender, receiver, amount, description);
            return "operation carried out successfully";
        }
        return "Insufficient balance or other issues. Please check and readjust the amount.";
    }

    public List<FriendVO> getAllFriends(long userID) {
        Set<UserAccount> friends = userAccountService.getFriends(userID);
        List<FriendVO> userFriends = new ArrayList<>();

        for (UserAccount friend : friends) {
            FriendVO userFriend = new FriendVO();
            userFriend.setId(friend.getId());
            userFriend.setFirstName(friend.getFirstName());
            userFriend.setEmail(friend.getEmail());

            userFriends.add(userFriend);
        }
        return userFriends;
    }


}
