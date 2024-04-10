package mg.inclusiv.config;


import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SecurityConfigTest {
    @Test
    public void testPasswordEncoder() {
        // Créer une instance du bean PasswordEncoder
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        // Mot de passe à encoder
        String password = "motDePasse";

        // Encoder le mot de passe
        String encodedPassword = passwordEncoder.encode(password);

        // Vérifier si le mot de passe encodé n'est pas vide
        assertNotEquals("", encodedPassword);

        // Vérifier si le mot de passe décodé correspond au mot de passe d'origine
        assertTrue(passwordEncoder.matches(password, encodedPassword));
    }


}

