package org.example.player_management_service.DAO;

import org.example.player_management_service.Model.Joueur;

import java.util.List;
import java.util.Optional;

public interface JoueurDAO {
    Joueur save(Joueur joueur);
    Optional<Joueur> findById(Long id);
    List<Joueur> findAll();
    void delete(Joueur joueur);
}
