# Plateforme de gestion des artisans

## Description

Cette plateforme vise à connecter les clients et les artisans dans un environnement où les clients peuvent facilement trouver des artisans qualifiés (plombiers, électriciens, etc.) et prendre rendez-vous avec eux. Les artisans peuvent gérer leurs rendez-vous, mettre à jour leurs informations et être notifiés des nouvelles demandes de rendez-vous.

---

## Problématique

En Afrique, il est souvent difficile de trouver un artisan disponible et fiable pour des travaux spécifiques (plombier, électricien, etc.). De plus, les artisans n’ont pas toujours un moyen efficace de gérer leurs rendez-vous avec les clients.

---

## Solution proposée

- **Pour les artisans :**
  - Inscription et création de profil.
  - Gestion de leur page personnelle : consultation des rendez-vous, mise à jour des informations de contact, spécialité et disponibilité.
  
- **Pour les clients :**
  - Recherche et consultation de la liste des artisans par spécialité.
  - Prise de rendez-vous avec un artisan en fonction de sa disponibilité.
  - Suivi du statut des rendez-vous (confirmé, annulé, etc.).

---

## Architecture

Le projet est basé sur une architecture **microservices** avec les services suivants :

1. **Service Artisan** : 
   - Gère les artisans (inscription, mise à jour des informations).
   - Base de données : artisans.
   
2. **Service Rendez-vous** : 
   - Gère la création et le suivi des rendez-vous entre clients et artisans.
   - Base de données : rendez-vous.
   
3. **Service Notification** (optionnel) :
   - Envoie des notifications par email ou SMS aux artisans et aux clients concernant les rendez-vous.

---

## Modèle de données

**1. Artisan Service (base de données)**

- **Table `artisans` :**
  - `id` : Identifiant unique.
  - `nom` : Nom de l'artisan.
  - `email` : Adresse e-mail.
  - `telephone` : Numéro de téléphone.
  - `specialite` : Spécialité (plombier, électricien, etc.).
  - `disponibilite` : Statut de disponibilité (oui/non).
  - `mot_de_passe` : Mot de passe pour la connexion.

**2. Rendez-vous Service (base de données)**

- **Table `rendezvous` :**
  - `id` : Identifiant unique.
  - `artisanId` : Identifiant de l'artisan concerné.
  - `clientNom` : Nom du client.
  - `clientContact` : Contact du client.
  - `date` : Date et heure du rendez-vous.
  - `statut` : Statut du rendez-vous (proposé, confirmé, annulé).

---

## Fonctionnalités

### **Pour les artisans :**
- S'inscrire sur la plateforme et renseigner leurs informations personnelles.
- Se connecter à une page dédiée pour consulter leurs rendez-vous et mettre à jour leurs informations.
- Confirmer ou refuser les rendez-vous proposés par les clients.

### **Pour les clients :**
- Rechercher des artisans par spécialité.
- Proposer un rendez-vous à un artisan, en sélectionnant une date et une heure.
- Suivre le statut du rendez-vous (proposé, confirmé, annulé).

---

## Instructions de développement

### 1. Préparer l'environnement

Assurez-vous d'avoir les outils suivants installés :
- Java JDK 17 ou supérieur.
- Spring Tools Suite (STS) ou IntelliJ IDEA.
- Maven pour la gestion des dépendances.
- Git pour la gestion des versions.
- MySQL ou une autre base de données compatible.
- Postman pour tester les API.
  
--

## Comment contribuer

1. **Clonez le dépôt :**
   ```bash
   git clone https://github.com/votre-utilisateur/gestion-artisans.git
 
