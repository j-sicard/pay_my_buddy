package com.openclassrooms.paymybuddy.fo;

import java.math.BigDecimal;

public class FriendTransferFO {

    private long userID;

    private  long friendID;

    private BigDecimal amount;

    public FriendTransferFO(long userID, long friendID, BigDecimal amount) {
        this.userID = userID;
        this.friendID = friendID;
        this.amount = amount;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public long getFriendID() {
        return friendID;
    }

    public void setFriendID(long friendID) {
        this.friendID = friendID;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
