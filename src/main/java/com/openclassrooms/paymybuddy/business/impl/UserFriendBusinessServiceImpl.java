package com.openclassrooms.paymybuddy.business.impl;

import com.openclassrooms.paymybuddy.entities.UserAccount;
import com.openclassrooms.paymybuddy.business.UserFriendBusinessService;
import com.openclassrooms.paymybuddy.services.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.SecondaryTable;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Set;

@Service
public class UserFriendBusinessServiceImpl implements UserFriendBusinessService {

    @Autowired
    UserAccountService userAccountService;


    public String addNewFriend(long userId, String friendEmail){
        UserAccount user = userAccountService.getUser(userId);
        UserAccount friend = userAccountService.getUserByEmail(friendEmail);
        if (userId != friend.getId() && !user.getAllFriends().contains(friend)){
              user.getAllFriends().add(friend);
              return "user " + friend.getFirstName() + " has been registered";
          }
          return "An error has occured";
    }

    public String creditFriendAcount(long userID, long friendID, BigDecimal amount) {
        userAccountService.credit(userAccountService.getFriendWithID(userID, friendID).getId(), amount );
        return userAccountService.getFriendWithID(userID, friendID).getFirstName();
    }

    public  UserAccount getFriendByID(long userID, long friendID){
        return userAccountService.getFriendWithID(userID, friendID);
    }

    @Transactional
    public UserAccount debitAccount(long userID, BigDecimal amount){
        return userAccountService.withdraw(userID, amount);
    }
}
