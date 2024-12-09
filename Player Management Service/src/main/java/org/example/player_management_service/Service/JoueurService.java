package org.example.player_management_service.Service;

import org.example.player_management_service.DTO.JoueurDTO;
import org.example.player_management_service.Model.Joueur;
import org.example.player_management_service.Repository.JoueurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoueurService {
    @Autowired
    private JoueurRepository joueurRepository;

    public Joueur creerJoueur(JoueurDTO joueurDTO) {
        Joueur joueur = new Joueur();
        joueur.setNom(joueurDTO.getNom());
        joueur.setPseudonyme(joueurDTO.getPseudonyme());
        joueur.setEmail(joueurDTO.getEmail());
        joueur.setNiveau(joueurDTO.getNiveau());
        joueur.setPointsTotaux(joueurDTO.getPointsTotaux());
        return joueurRepository.save(joueur);
    }

    public Joueur trouverJoueurParId(Long id) {
        return joueurRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Joueur introuvable"));
    }

    public List<Joueur> getAllJoueurs() {
        return joueurRepository.findAll();
    }

    public Joueur updateJoueur(Long id, JoueurDTO joueurDetails) {
        Joueur joueur = joueurRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Joueur introuvable"));

        joueur.setNom(joueurDetails.getNom());
        joueur.setPseudonyme(joueurDetails.getPseudonyme());
        joueur.setEmail(joueurDetails.getEmail());
        joueur.setNiveau(joueurDetails.getNiveau());
        joueur.setPointsTotaux(joueurDetails.getPointsTotaux());

        return joueurRepository.save(joueur);
    }

    public void deleteJoueur(Long id) {
        Joueur joueur = joueurRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Joueur introuvable"));

        joueurRepository.delete(joueur);
    }


}
