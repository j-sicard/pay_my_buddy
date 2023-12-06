package com.openclassrooms.paymybuddy.business;

import com.openclassrooms.paymybuddy.entities.UserAccount;
import com.openclassrooms.paymybuddy.vo.FriendVO;

import java.math.BigDecimal;
import java.util.List;

public interface UserFriendBusinessService {

    public String addNewFriend(long userId, String friendEmail);


    public  UserAccount getFriendByID(long userID, long friendID);


    public String debitAccount(long senderID, long receiverID,  BigDecimal amount, String description);

    public List<FriendVO> getAllFriends(long userID);
}
