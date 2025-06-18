package org.example.deliverymatch.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Trajet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTrajet;

    private String lieuDepart;

    @ElementCollection
    private List<String> etapesIntermediaires;

    private String destinationFinale;
    private float dimensionsMaximalesAcceptees;
    private String typeDeMarchandise;
    private float capaciteDisponible;

    @ManyToOne
    @JoinColumn(name = "conducteur_id")
    private Conducteur conducteur;

    @OneToMany(mappedBy = "trajet", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Demande> demandes;

    public Long getIdTrajet() {
        return idTrajet;
    }

    public void setIdTrajet(Long idTrajet) {
        this.idTrajet = idTrajet;
    }

    public String getLieuDepart() {
        return lieuDepart;
    }

    public void setLieuDepart(String lieuDepart) {
        this.lieuDepart = lieuDepart;
    }

    public List<String> getEtapesIntermediaires() {
        return etapesIntermediaires;
    }

    public void setEtapesIntermediaires(List<String> etapesIntermediaires) {
        this.etapesIntermediaires = etapesIntermediaires;
    }

    public String getDestinationFinale() {
        return destinationFinale;
    }

    public void setDestinationFinale(String destinationFinale) {
        this.destinationFinale = destinationFinale;
    }

    public float getDimensionsMaximalesAcceptees() {
        return dimensionsMaximalesAcceptees;
    }

    public void setDimensionsMaximalesAcceptees(float dimensionsMaximalesAcceptees) {
        this.dimensionsMaximalesAcceptees = dimensionsMaximalesAcceptees;
    }

    public String getTypeDeMarchandise() {
        return typeDeMarchandise;
    }

    public void setTypeDeMarchandise(String typeDeMarchandise) {
        this.typeDeMarchandise = typeDeMarchandise;
    }

    public float getCapaciteDisponible() {
        return capaciteDisponible;
    }

    public void setCapaciteDisponible(float capaciteDisponible) {
        this.capaciteDisponible = capaciteDisponible;
    }

    public Conducteur getConducteur() {
        return conducteur;
    }

    public void setConducteur(Conducteur conducteur) {
        this.conducteur = conducteur;
    }

    public List<Demande> getDemandes() {
        return demandes;
    }

    public void setDemandes(List<Demande> demandes) {
        this.demandes = demandes;
    }
}
