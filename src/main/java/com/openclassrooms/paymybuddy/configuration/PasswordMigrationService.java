package com.openclassrooms.paymybuddy.configuration;

import com.openclassrooms.paymybuddy.entities.UserAccount;
import com.openclassrooms.paymybuddy.repositories.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class PasswordMigrationService {
    @Autowired
    private UserAccountRepository userAccountRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostConstruct
    public void migratePasswords() {
        List<UserAccount> users = (List<UserAccount>) userAccountRepository.findAll();

        for (UserAccount user : users) {
            String existingPassword = user.getPassword();

            // Vérifier si le mot de passe est déjà encodé avec BCrypt
            if (!existingPassword.startsWith("$2a$10$")) {
                // Si ce n'est pas le cas, réencoder le mot de passe
                String newPassword = passwordEncoder.encode(existingPassword);
                user.setPassword(newPassword);
                userAccountRepository.save(user);
            }
        }
    }
}
