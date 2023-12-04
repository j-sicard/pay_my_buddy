package com.openclassrooms.paymybuddy.fo;

public class FriendFO {
    private long userID;

    private  String friendEmail;

    public FriendFO(long userID, String friendEmail) {
        this.userID = userID;
        this.friendEmail = friendEmail;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public String getFriendEmail() {
        return friendEmail;
    }

    public void setFriendEmail(String friendEmail) {
        this.friendEmail = friendEmail;
    }
}
