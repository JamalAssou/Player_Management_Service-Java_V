package org.example.player_management_service.Repository;

import org.example.player_management_service.Model.Joueur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JoueurRepository extends JpaRepository<Joueur, Long> {
    Optional<Joueur> findByPseudonyme(String pseudonyme);
}
