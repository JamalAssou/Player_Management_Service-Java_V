package org.example.player_management_service.Service;

import org.example.player_management_service.Model.Ami;
import org.example.player_management_service.Model.Joueur;
import org.example.player_management_service.Repository.AmiRepository;
import org.example.player_management_service.Repository.JoueurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AmiService {
    @Autowired
    private JoueurRepository joueurRepository;
    @Autowired
    private AmiRepository amiRepository;

    public Ami addAmi(Long joueurId, Long amiId) {
        Joueur joueur = joueurRepository.findById(joueurId)
                .orElseThrow(() -> new RuntimeException("Joueur introuvable"));
        Joueur ami = joueurRepository.findById(amiId)
                .orElseThrow(() -> new RuntimeException("Ami introuvable"));

        Ami newAmi = new Ami();
        newAmi.setJoueur(joueur);
        newAmi.setAmi(ami);

        return amiRepository.save(newAmi);
    }

    public List<Joueur> getAmis(Long joueurId) {
        return amiRepository.findAmisByJoueurId(joueurId);
    }

}
