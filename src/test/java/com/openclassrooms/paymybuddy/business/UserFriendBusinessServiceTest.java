package com.openclassrooms.paymybuddy.business;

import com.openclassrooms.paymybuddy.AbstractConfigurationTest;
import com.openclassrooms.paymybuddy.business.impl.UserFriendBusinessServiceImpl;
import com.openclassrooms.paymybuddy.entities.UserAccount;
import com.openclassrooms.paymybuddy.services.UserAccountService;
import com.openclassrooms.paymybuddy.vo.FriendVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static net.bytebuddy.matcher.ElementMatchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

class UserFriendBusinessServiceTest extends AbstractConfigurationTest {

    @Mock
    private UserAccountService userAccountService;

    @InjectMocks
    private UserFriendBusinessServiceImpl userFriendBusinessService;

    private long userId;
    private UserAccount user;
    private UserAccount friend1;
    private UserAccount friend2;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        initializeTestData();
    }

    private void initializeTestData() {
        userId = 1L;
        user = new UserAccount();
        user.setId(userId);

        friend1 = new UserAccount();
        friend1.setId(2L);
        friend1.setFirstName("John");
        friend1.setEmail("john@email.com");

        friend2 = new UserAccount();
        friend2.setId(3L);
        friend2.setFirstName("Jane");
        friend2.setEmail("jane@email.com");
    }

    @Test
    void testGetAllFriends() {
        // Simulez le comportement du service pour renvoyer ces amis
        Set<UserAccount> friends = new HashSet<>();
        friends.add(friend1);
        friends.add(friend2);
        when(userAccountService.getFriends(userId)).thenReturn(friends);

        List<FriendVO> userFriends = userFriendBusinessService.getAllFriends(userId);

        assertEquals(2, userFriends.size());

        FriendVO friendVO1 = userFriends.get(0);
        assertEquals(friend1.getId(), friendVO1.getId());
        assertEquals(friend1.getFirstName(), friendVO1.getFirstName());
        assertEquals(friend1.getEmail(), friendVO1.getEmail());

        FriendVO friendVO2 = userFriends.get(1);
        assertEquals(friend2.getId(), friendVO2.getId());
        assertEquals(friend2.getFirstName(), friendVO2.getFirstName());
        assertEquals(friend2.getEmail(), friendVO2.getEmail());
    }

    @Test
    void testGetFriendByID() {
        // Simulez le comportement du service pour renvoyer cet ami
        when(userAccountService.getFriendWithID(userId, friend1.getId())).thenReturn(friend1);

        UserAccount returnedFriend = userFriendBusinessService.getFriendByID(userId, friend1.getId());

        assertEquals(friend1.getId(), returnedFriend.getId());
        assertEquals(friend1.getFirstName(), returnedFriend.getFirstName());
        assertEquals(friend1.getEmail(), returnedFriend.getEmail());
    }

    @Test
    void testAddNewFriendSuccess() {
        long userId = 1L;
        UserAccount user = new UserAccount();
        user.setId(userId);

        long friendId = 2L;
        UserAccount friend = new UserAccount();
        friend.setId(friendId);
        friend.setFirstName("John");
        friend.setEmail("john@email.com");
        // Configurer le comportement du service pour renvoyer les utilisateurs factices
        when(userAccountService.getUser(userId)).thenReturn(user);
        when(userAccountService.getUserByEmail(friend.getEmail())).thenReturn(friend);

        String result = userFriendBusinessService.addNewFriend(userId, friend.getEmail());

        assertEquals("user John has been registered", result);
    }

   /* @Test
    void testTransferMoneyUserAtUser_SuccessfulTransfer() {
        long senderID = 1L;
        long receiverID = 2L;
        BigDecimal amount = new BigDecimal("50.0");

        UserAccount sender = new UserAccount();
        sender.setId(senderID);
        sender.setBalance(new BigDecimal("100.0"));

        UserAccount receiver = new UserAccount();
        receiver.setId(receiverID);

        // Configurer le comportement du service pour renvoyer les utilisateurs factices
        when(userAccountService.getUser(senderID)).thenReturn(sender);
        when(userAccountService.getUser(receiverID)).thenReturn(receiver);
        when(userAccountService.debitedUser(eq(senderID), eq(amount))).thenReturn(true);
        when(userAccountService.credit(anyLong(), (BigDecimal) any())).thenReturn(true);

// Appeler la méthode que vous testez
        String result = userFriendBusinessService.transferMoneyUserAtUser(senderID, receiverID, amount, "Test transfer");

// Vérifier le résultat
        assertEquals("operation carried out successfully", result);
    }*/

    @Test
    void testTransferMoneyUserAtUser_InsufficientBalance() {
        // Créer des utilisateurs factices
        long senderID = 1L;
        long receiverID = 2L;
        BigDecimal amount = new BigDecimal("150.0");
        String description = "Test transfer";

        UserAccount sender = new UserAccount();
        sender.setId(senderID);
        sender.setBalance(new BigDecimal("100.0"));

        UserAccount receiver = new UserAccount();
        receiver.setId(receiverID);

        // Configurer le comportement du service pour renvoyer les utilisateurs factices
        when(userAccountService.getUser(senderID)).thenReturn(sender);
        when(userAccountService.getUser(receiverID)).thenReturn(receiver);

        // Appeler la méthode que vous testez
        String result = userFriendBusinessService.transferMoneyUserAtUser(senderID, receiverID, amount, description);

        // Vérifier le résultat
        assertEquals("Insufficient balance or other issues. Please check and readjust the amount.", result);
    }
}
