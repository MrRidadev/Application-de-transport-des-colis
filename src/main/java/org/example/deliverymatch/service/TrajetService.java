package org.example.deliverymatch.service;


import jakarta.transaction.Transactional;
import org.example.deliverymatch.DTO.DemandeSimpleDTO;
import org.example.deliverymatch.DTO.TrajetHistoriqueDTO;
import org.example.deliverymatch.entity.Demande;
import org.example.deliverymatch.entity.Trajet;
import org.example.deliverymatch.repository.TrajetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    @Transactional
    public List<TrajetHistoriqueDTO> findAll() {
        List<Trajet> trajets = trajetRepository.findAll();

        return trajets.stream().map(trajet -> {
            TrajetHistoriqueDTO dto = new TrajetHistoriqueDTO();
            dto.setIdTrajet(trajet.getIdTrajet());
            dto.setLieuDepart(trajet.getLieuDepart());
            dto.setDestinationFinale(trajet.getDestinationFinale());

            // ✅ Mapping des demandes (colis transportés)
            List<DemandeSimpleDTO> demandesDTO = trajet.getDemandes().stream()
                    .map(demande -> {
                        DemandeSimpleDTO dDto = new DemandeSimpleDTO();
                        dDto.setIdDemande(demande.getIdDemande());
                        dDto.setTypeColis(demande.getTypeColis());
                        dDto.setPoids(demande.getPoids());
                        return dDto;
                    })
                    .collect(Collectors.toList());

            dto.setColisTransportes(demandesDTO);

            return dto;
        }).collect(Collectors.toList());
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
