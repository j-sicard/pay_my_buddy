package com.openclassrooms.paymybuddy.services.impl;

import com.openclassrooms.paymybuddy.repositories.UserAccountRepository;
import com.openclassrooms.paymybuddy.services.UserAccountFriendService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserAccountFriendServiceImpl implements UserAccountFriendService {

    @Autowired
    UserAccountRepository userAccountRepository;


}
