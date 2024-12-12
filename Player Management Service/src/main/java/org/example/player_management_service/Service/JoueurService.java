package org.example.player_management_service.Service;

import org.example.player_management_service.DAO.JoueurDAO;
import org.example.player_management_service.DTO.JoueurDTO;
import org.example.player_management_service.Model.Joueur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoueurService {

    @Autowired
    private JoueurDAO joueurDAO;

    public Joueur creerJoueur(JoueurDTO joueurDTO) {
        Joueur joueur = new Joueur();
        joueur.setNom(joueurDTO.getNom());
        joueur.setPseudonyme(joueurDTO.getPseudonyme());
        joueur.setEmail(joueurDTO.getEmail());
        joueur.setNiveau(joueurDTO.getNiveau());
        joueur.setPointsTotaux(joueurDTO.getPointsTotaux());
        return joueurDAO.save(joueur);
    }

    public Joueur trouverJoueurParId(Long id) {
        return joueurDAO.findById(id)
                .orElseThrow(() -> new RuntimeException("Joueur introuvable"));
    }

    public List<Joueur> getAllJoueurs() {
        return joueurDAO.findAll();
    }

    public Joueur updateJoueur(Long id, JoueurDTO joueurDetails) {
        Joueur joueur = joueurDAO.findById(id)
                .orElseThrow(() -> new RuntimeException("Joueur introuvable"));

        joueur.setNom(joueurDetails.getNom());
        joueur.setPseudonyme(joueurDetails.getPseudonyme());
        joueur.setEmail(joueurDetails.getEmail());
        joueur.setNiveau(joueurDetails.getNiveau());
        joueur.setPointsTotaux(joueurDetails.getPointsTotaux());

        return joueurDAO.save(joueur);
    }

    public void deleteJoueur(Long id) {
        Joueur joueur = joueurDAO.findById(id)
                .orElseThrow(() -> new RuntimeException("Joueur introuvable"));

        joueurDAO.delete(joueur);
    }
}
