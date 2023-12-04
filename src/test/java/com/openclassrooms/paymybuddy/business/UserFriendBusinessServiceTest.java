package com.openclassrooms.paymybuddy.business;

import com.openclassrooms.paymybuddy.AbstractConfigurationTest;
import com.openclassrooms.paymybuddy.business.impl.UserFriendBusinessServiceImpl;
import com.openclassrooms.paymybuddy.entities.UserAccount;
import com.openclassrooms.paymybuddy.services.UserAccountService;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/*

public class UserFriendBusinessServiceTest extends AbstractConfigurationTest {

    @Autowired
    UserFriendBusinessServiceImpl userFriendBusinessService;

    @Autowired
    UserAccountService userAccountService;

   @Test
    void testAddNewFriend() {
        userFriendBusinessService.addNewFriend(17,"NewFriend@test.fr");
        UserAccount updateFriendList = userAccountService.getUser(17);
        assertEquals(1, updateFriendList.getFriends().size());
    }

}
*/
