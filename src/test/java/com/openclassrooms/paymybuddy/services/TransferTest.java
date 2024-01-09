package com.openclassrooms.paymybuddy.services;


import com.openclassrooms.paymybuddy.AbstractConfigurationTest;

import com.openclassrooms.paymybuddy.entities.Transfer;
import com.openclassrooms.paymybuddy.entities.UserAccount;
import com.openclassrooms.paymybuddy.repositories.TransferRepository;

import com.openclassrooms.paymybuddy.services.impl.TransferServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class TransferTest extends AbstractConfigurationTest {
    @Mock
    private TransferRepository transferRepository;

    @InjectMocks
    private TransferServiceImpl transferService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetTransfers() {
        // utilisateur factice
        UserAccount user = new UserAccount();
        user.setId(1L);

        // transferts factices
        Transfer transfer1 = new Transfer();
        transfer1.setId(1L);
        transfer1.setAmount(new BigDecimal(100.0));
        transfer1.setUser(user);

        Transfer transfer2 = new Transfer();
        transfer2.setId(2L);
        transfer2.setAmount(new BigDecimal(50.0));
        transfer2.setUser(user);

        // Simule le comportement du repository pour renvoyer ces transferts
        when(transferRepository.findByUser(user)).thenReturn(Arrays.asList(transfer1, transfer2));

        // Appelez la méthode que vous testez
        List<Transfer> userTransfers = transferService.getTransfers(user);

        assertEquals(2, userTransfers.size());

        Transfer retrievedTransfer1 = userTransfers.get(0);
        assertEquals(transfer1.getId(), retrievedTransfer1.getId());
        assertEquals(transfer1.getAmount(), retrievedTransfer1.getAmount());
        assertEquals(transfer1.getUser(), retrievedTransfer1.getUser());

        Transfer retrievedTransfer2 = userTransfers.get(1);
        assertEquals(transfer2.getId(), retrievedTransfer2.getId());
        assertEquals(transfer2.getAmount(), retrievedTransfer2.getAmount());
        assertEquals(transfer2.getUser(), retrievedTransfer2.getUser());
    }
    @Test
    void testCreateTransfer() {
        //  utilisateurs factices
        UserAccount sender = new UserAccount();
        sender.setId(1L);

        UserAccount receiver = new UserAccount();
        receiver.setId(2L);
        receiver.setFirstName("John");

        // Vérifie le résultat
        assertTrue(transferService.createTransfer(sender, receiver, new BigDecimal("100.0"), "Description"));

        // Vérifie que le transfert a été correctement sauvegardé
        ArgumentCaptor<Transfer> transferCaptor = ArgumentCaptor.forClass(Transfer.class);
        verify(transferRepository).save(transferCaptor.capture());
        Transfer savedTransfer = transferCaptor.getValue();

        assertEquals(sender, savedTransfer.getUser());
        assertEquals(receiver.getFirstName(), savedTransfer.getReceiverFirstName());
        assertEquals(new BigDecimal("100.0"), savedTransfer.getAmount());
    }
}