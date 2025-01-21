package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Artisan;
import com.example.demo.Entity.DemandeRendezVous;
import com.example.demo.service.ArtisanService;

@RestController
@RequestMapping("/api/artisans")
public class ArtisanController {

    @Autowired
    private ArtisanService artisanService;

    @GetMapping
    public List<Artisan> getAllArtisans() {
        return artisanService.getAllArtisans();
    }

    @GetMapping("/{id}")
    public Optional<Artisan> getArtisanById(@PathVariable Long id) {
        return artisanService.getArtisanById(id);
    }

    @PostMapping
    public Artisan createArtisan(@RequestBody Artisan artisan) {
        return artisanService.addArtisan(artisan);
    }

    @PutMapping("/{id}")
    public Artisan updateArtisan(@PathVariable Long id, @RequestBody Artisan artisan) {
        return artisanService.updateArtisan(id, artisan);
    }

    @DeleteMapping("/{id}")
    public void deleteArtisan(@PathVariable Long id) {
        artisanService.deleteArtisan(id);
    }
    
    private final List<DemandeRendezVous> demandes = new ArrayList<>();
    
 // Endpoint pour recevoir une demande
    @PostMapping("/{artisanId}/demandes")
    public ResponseEntity<String> recevoirDemande(@PathVariable Long artisanId, @RequestBody DemandeRendezVous demande) {
        demande.setId((long) (demandes.size() + 1)); // Simule l'ajout d'un ID unique
        demandes.add(demande);
        return ResponseEntity.ok("Demande recue avec succes par l'artisan !");
    }

    // Endpoint pour afficher toutes les demandes
    @GetMapping("/{artisanId}/demandes")
    public ResponseEntity<List<DemandeRendezVous>> getDemandes(@PathVariable Long artisanId) {
        return ResponseEntity.ok(demandes);
    }
}