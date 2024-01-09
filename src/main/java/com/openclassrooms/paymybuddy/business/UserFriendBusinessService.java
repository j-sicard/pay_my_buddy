package com.openclassrooms.paymybuddy.business;

import com.openclassrooms.paymybuddy.entities.UserAccount;
import com.openclassrooms.paymybuddy.vo.FriendVO;
import com.openclassrooms.paymybuddy.vo.TransferVO;

import java.math.BigDecimal;
import java.util.List;

public interface UserFriendBusinessService {

    public String addNewFriend(long userId, String friendEmail);


    public  UserAccount getFriendByID(long userID, long friendID);


    public String transferMoneyUserAtUser(long senderID, long receiverID, BigDecimal amount, String description);

    public List<FriendVO> getAllFriends(long userID);

    public List<TransferVO> findAllTransferByUserID(long userID);

}
