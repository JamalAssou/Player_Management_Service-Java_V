package org.example.player_management_service.DAO;

import org.example.player_management_service.Model.Joueur;
import org.example.player_management_service.Repository.JoueurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JoueurDAOImpl implements JoueurDAO {

    @Autowired
    private JoueurRepository joueurRepository;

    @Override
    public Joueur save(Joueur joueur) {
        return joueurRepository.save(joueur);
    }

    @Override
    public Optional<Joueur> findById(Long id) {
        return joueurRepository.findById(id);
    }

    @Override
    public List<Joueur> findAll() {
        return joueurRepository.findAll();
    }

    @Override
    public void delete(Joueur joueur) {
        joueurRepository.delete(joueur);
    }
}
