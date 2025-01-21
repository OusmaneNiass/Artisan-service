package com.example.demo.Entity;


import java.time.LocalDateTime;

public class DemandeRendezVous {
    private Long id;
    private Long clientId; // ID du client qui envoie la demande
    private String message; // Message de la demande
    private LocalDateTime dateDemande; // Date et heure de la demande

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getDateDemande() {
        return dateDemande;
    }

    public void setDateDemande(LocalDateTime dateDemande) {
        this.dateDemande = dateDemande;
    }
}
