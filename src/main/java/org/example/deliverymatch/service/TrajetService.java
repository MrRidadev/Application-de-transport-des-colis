package org.example.deliverymatch.service;


import org.example.deliverymatch.DTO.DemandeSimpleDTO;
import org.example.deliverymatch.DTO.TrajetHistoriqueDTO;
import org.example.deliverymatch.entity.Demande;
import org.example.deliverymatch.entity.Trajet;
import org.example.deliverymatch.repository.TrajetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrajetService {

    private TrajetRepository trajetRepository;


    @Autowired
    public TrajetService(TrajetRepository conducteurRepository) {
        this.trajetRepository = conducteurRepository;
    }


    public Trajet addTrajet(Trajet trajet) {
       return trajetRepository.save(trajet);
    }

    public List<Trajet> findAll() {
        return trajetRepository.findAll();
    }

    public List<TrajetHistoriqueDTO> getHistoriqueConducteur(Long conducteurId) {
        List<Trajet> trajets = trajetRepository.findByConducteurId(conducteurId);
        List<TrajetHistoriqueDTO> result = new ArrayList<>();

        for (Trajet trajet : trajets) {
            TrajetHistoriqueDTO dto = new TrajetHistoriqueDTO();
            dto.setIdTrajet(trajet.getIdTrajet());
            dto.setLieuDepart(trajet.getLieuDepart());
            dto.setDestinationFinale(trajet.getDestinationFinale());


            List<DemandeSimpleDTO> DemandeSimpleDTO  = new ArrayList<>();
            for (Demande demande : trajet.getDemandes()) {
                DemandeSimpleDTO  dt = new DemandeSimpleDTO ();
                dt.setIdDemande(demande.getIdDemande());
                dt.setTypeColis(demande.getTypeColis());
                dt.setPoids(demande.getPoids());
                DemandeSimpleDTO .add(dt);
            }

            dto.setColisTransportes(DemandeSimpleDTO );
            result.add(dto);
        }

        return result;
    }


    public List<Trajet> filtrerParLieuEtDestination(String lieuDepart, String destinationFinale) {
        return trajetRepository.findByLieuDepartAndDestinationFinale(lieuDepart, destinationFinale);
    }
}
