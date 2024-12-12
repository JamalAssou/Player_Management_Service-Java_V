package org.example.player_management_service.Service;

import org.example.player_management_service.DAO.AmiDAO;
import org.example.player_management_service.DAO.JoueurDAO;
import org.example.player_management_service.Model.Ami;
import org.example.player_management_service.Model.Joueur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AmiService {

    @Autowired
    private JoueurDAO joueurDAO;

    @Autowired
    private AmiDAO amiDAO;

    public Ami ajouterAmi(Long joueurId, Long amiId) {
        Joueur joueur = joueurDAO.findById(joueurId)
                .orElseThrow(() -> new RuntimeException("Joueur introuvable"));

        Ami ami = new Ami();
        ami.setJoueur(joueur);
        ami.setId(amiId);

        return amiDAO.save(ami);
    }

    public List<Ami> obtenirAmis(Long joueurId) {
        Joueur joueur = joueurDAO.findById(joueurId)
                .orElseThrow(() -> new RuntimeException("Joueur non trouvé avec l'ID : " + joueurId));

        return joueur.getAmis();
    }
}
