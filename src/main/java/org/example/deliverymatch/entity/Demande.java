package org.example.deliverymatch.entity;

import jakarta.persistence.*;

@Entity
public class Demande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDemande;

    private float longueur;
    private float poids;
    private String typeColis;
    private float largeur;
    private float hauteur;

    @Enumerated(EnumType.STRING)
    private Etat etat;

    @ManyToOne
    @JoinColumn(name = "expediteur_id")
    private Expediteur expediteur;

    @ManyToOne
    @JoinColumn(name = "trajet_id")
    private Trajet trajet;

    // Getters and setters
    public Long getIdDemande() {
        return idDemande;
    }

    public void setIdDemande(Long idDemande) {
        this.idDemande = idDemande;
    }

    public float getLongueur() {
        return longueur;
    }

    public void setLongueur(float longueur) {
        this.longueur = longueur;
    }

    public float getPoids() {
        return poids;
    }

    public void setPoids(float poids) {
        this.poids = poids;
    }

    public String getTypeColis() {
        return typeColis;
    }

    public void setTypeColis(String typeColis) {
        this.typeColis = typeColis;
    }

    public float getLargeur() {
        return largeur;
    }

    public void setLargeur(float largeur) {
        this.largeur = largeur;
    }

    public float getHauteur() {
        return hauteur;
    }

    public void setHauteur(float hauteur) {
        this.hauteur = hauteur;
    }

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    public Expediteur getExpediteur() {
        return expediteur;
    }

    public void setExpediteur(Expediteur expediteur) {
        this.expediteur = expediteur;
    }

    public Trajet getTrajet() {
        return trajet;
    }

    public void setTrajet(Trajet trajet) {
        this.trajet = trajet;
    }
}
