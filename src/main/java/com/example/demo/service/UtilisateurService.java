package com.example.demo.service;

import com.example.demo.Entity.Utilisateur;
import com.example.demo.Repository.UtilisateurRepository;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public Utilisateur inscrireUtilisateur(Utilisateur utilisateur) {
        // Définir un rôle par défaut si aucun n'est fourni
        if (utilisateur.getRoles() == null || utilisateur.getRoles().isEmpty()) {
            utilisateur.setRoles(Collections.singleton("ROLE_USER"));
        }
        return utilisateurRepository.save(utilisateur);
    }

    public Utilisateur trouverParEmail(String email) {
        return utilisateurRepository.findByEmail(email);
    }

    public boolean verifierAuthentification(String email, String password) {
        Utilisateur utilisateur = utilisateurRepository.findByEmail(email);
        if (utilisateur != null) {
            return utilisateur.getPassword().equals(password);
        }
        return false;
    }
}
