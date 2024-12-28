package com.example.demo.Controller;

import com.example.demo.Entity.Utilisateur;
import com.example.demo.service.UtilisateurService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UtilisateurService utilisateurService;

    // Endpoint pour l'inscription
    @PostMapping("/inscription")
    public ResponseEntity<?> inscrire(@RequestBody Utilisateur utilisateur) {
        // Vérifiez si l'utilisateur possède un artisan à associer
        if (utilisateur.getArtisan() != null) {
            utilisateur.getArtisan().setUtilisateur(utilisateur); // Associez l'utilisateur à l'artisan
        }
        Utilisateur newUser = utilisateurService.inscrireUtilisateur(utilisateur);
        return ResponseEntity.ok(newUser);
    }

    // Endpoint pour récupérer un utilisateur par email
    @GetMapping("/utilisateur/{email}")
    public ResponseEntity<?> trouverUtilisateur(@PathVariable String email) {
        Utilisateur utilisateur = utilisateurService.trouverParEmail(email);
        if (utilisateur == null) {
            return ResponseEntity.status(404).body("Utilisateur non trouvé !");
        }
        return ResponseEntity.ok(utilisateur);
    }

    // Endpoint pour la connexion
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Utilisateur utilisateur) {
        boolean isAuthentic = utilisateurService.verifierAuthentification(utilisateur.getEmail(), utilisateur.getPassword());
        if (isAuthentic) {
            return ResponseEntity.ok("Connexion réussie !");
        } else {
            return ResponseEntity.status(401).body("Email ou mot de passe incorrect !");
        }
    }
}
