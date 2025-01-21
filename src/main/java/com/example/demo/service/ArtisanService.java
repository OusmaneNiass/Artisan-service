package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Artisan;
import com.example.demo.Entity.DemandeRendezVous;
import com.example.demo.Repository.ArtisanRepository;

@Service
public class ArtisanService {

    @Autowired
    private ArtisanRepository artisanRepository;

    // Récupérer la liste de tous les artisans
    public List<Artisan> getAllArtisans() {
        return artisanRepository.findAll();
    }

    // Récupérer un artisan par ID
    public Optional<Artisan> getArtisanById(Long id) {
        return artisanRepository.findById(id);
    }

    // Ajouter un nouvel artisan
    public Artisan addArtisan(Artisan artisan) {
        return artisanRepository.save(artisan);
    }

    // Mettre à jour un artisan
    public Artisan updateArtisan(Long id, Artisan artisanDetails) {
        Artisan artisan = artisanRepository.findById(id).orElseThrow(() -> new RuntimeException("Artisan non trouvé"));
        artisan.setNom(artisanDetails.getNom());
        artisan.setEmail(artisanDetails.getEmail());
        artisan.setTelephone(artisanDetails.getTelephone());
        artisan.setSpecialite(artisanDetails.getSpecialite());
        artisan.setDisponible(artisanDetails.getDisponible());
        return artisanRepository.save(artisan);
    }

    // Supprimer un artisan
    public void deleteArtisan(Long id) {
        Artisan artisan = artisanRepository.findById(id).orElseThrow(() -> new RuntimeException("Artisan non trouvé"));
        artisanRepository.delete(artisan);
    }
    
    public void creerDemande(Long artisanId, DemandeRendezVous demande) {
        Artisan artisan = artisanRepository.findById(artisanId)
                            .orElseThrow(() -> new RuntimeException("Artisan non trouvé"));

        // Ajouter la logique pour enregistrer ou traiter la demande
        System.out.println("Demande reçue pour l'artisan " + artisan.getNom() + " : " + demande.getMessage());
    }
}