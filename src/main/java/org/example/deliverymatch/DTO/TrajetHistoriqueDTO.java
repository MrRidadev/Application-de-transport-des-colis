package org.example.deliverymatch.DTO;

import java.util.List;

public class TrajetHistoriqueDTO {

    private Long idTrajet;
    private String lieuDepart;
    private String destinationFinale;
    private List<DemandeSimpleDTO> colisTransportes;

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

    public String getDestinationFinale() {
        return destinationFinale;
    }

    public void setDestinationFinale(String destinationFinale) {
        this.destinationFinale = destinationFinale;
    }

    public List<DemandeSimpleDTO> getColisTransportes() {
        return colisTransportes;
    }

    public void setColisTransportes(List<DemandeSimpleDTO> colisTransportes) {
        this.colisTransportes = colisTransportes;
    }
}
