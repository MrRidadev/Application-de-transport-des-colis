package org.example.deliverymatch.service;

import org.example.deliverymatch.DTO.DemandeDTO;
import org.example.deliverymatch.entity.Demande;
import org.example.deliverymatch.entity.Expediteur;
import org.example.deliverymatch.repository.DemandeRepository;
import org.example.deliverymatch.repository.ExpediteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DemandeService {

    private final DemandeRepository demandeRepository;
    @Autowired
    public DemandeService(DemandeRepository demandeRepository) {
        this.demandeRepository = demandeRepository;
    }

    // ajouter demande
    public Demande addDemande(Demande demande) {
        return demandeRepository.save(demande);
    }
    // afficher demande

    public List<Demande> getDemandes() {
        return demandeRepository.findAll();
    }


    public List<DemandeDTO> getDemandesAvecRelations() {
        List<Demande> demandes = demandeRepository.findAll();
        List<DemandeDTO> dtos = new ArrayList<>();

        for (Demande demande : demandes) {
            DemandeDTO dto = new DemandeDTO();
            dto.setIdDemande(demande.getIdDemande());
            dto.setLongueur(demande.getLongueur());
            dto.setPoids(demande.getPoids());
            dto.setTypeColis(demande.getTypeColis());
            dto.setLargeur(demande.getLargeur());
            dto.setHauteur(demande.getHauteur());
            dto.setEtat(demande.getEtat().toString());

            // Relations
            if (demande.getExpediteur() != null) {
                dto.setNomComplet(demande.getExpediteur().getNomComplet());
            }
            if (demande.getTrajet() != null) {
                dto.setLieuDepart(demande.getTrajet().getLieuDepart());
                dto.setDestinationFinale(demande.getTrajet().getDestinationFinale());
            }

            dtos.add(dto);
        }

        return dtos;
    }


}
