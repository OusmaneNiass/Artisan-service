package com.example.demo;

import com.example.demo.Entity.Utilisateur;
import com.example.demo.service.UtilisateurService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.Set;  // Ajout de l'importation Set

@Component
public class DefaultAdminUser implements CommandLineRunner {

    private final UtilisateurService utilisateurService;

    public DefaultAdminUser(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @Override
    public void run(String... args) throws Exception {
        if (utilisateurService.trouverParEmail("admin@example.com") == null) {
            Utilisateur admin = new Utilisateur();
            admin.setEmail("admin@example.com");
            admin.setPassword("adminPassword"); // Mot de passe en clair
            admin.setRoles(Set.of("ROLE_ADMIN"));
            utilisateurService.inscrireUtilisateur(admin);
            System.out.println("Utilisateur admin par défaut créé.");
        } else {
            System.out.println("Utilisateur admin déjà existant.");
        }
    }
}
