package com.openclassrooms.paymybuddy.business;

import com.openclassrooms.paymybuddy.entities.UserAccount;

import java.math.BigDecimal;

public interface UserFriendBusinessService {

    public String addNewFriend(long userId, String friendEmail);

    public String creditFriendAcount(long userID, long friendID, BigDecimal amount);

    public  UserAccount getFriendByID(long userID, long friendID);

    public UserAccount debitAccount(long userID, BigDecimal amount);

}
