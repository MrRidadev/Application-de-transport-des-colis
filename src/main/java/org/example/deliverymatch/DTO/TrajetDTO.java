package org.example.deliverymatch.DTO;

import java.util.List;

public class TrajetDTO {

    private Long idTrajet;
    private String lieuDepart;
    private String destinationFinale;
    private List<DemandeDTO> colisTransportes;


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

    public List<DemandeDTO> getColisTransportes() {
        return colisTransportes;
    }

    public void setColisTransportes(List<DemandeDTO> colisTransportes) {
        this.colisTransportes = colisTransportes;
    }
}
