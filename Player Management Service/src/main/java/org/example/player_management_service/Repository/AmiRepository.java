package org.example.player_management_service.Repository;

import org.example.player_management_service.Model.Ami;
import org.example.player_management_service.Model.Joueur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AmiRepository extends JpaRepository<Ami, Long> {

    @Query("SELECT a.ami FROM Ami a WHERE a.joueur.id = :joueurId")
    List<Joueur> findAmisByJoueurId(@Param("joueurId") Long joueurId);

}


