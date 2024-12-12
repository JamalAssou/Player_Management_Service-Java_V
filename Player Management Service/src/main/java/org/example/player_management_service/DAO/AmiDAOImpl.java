package org.example.player_management_service.DAO;

import org.example.player_management_service.Model.Ami;
import org.example.player_management_service.Repository.AmiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AmiDAOImpl implements AmiDAO {

    @Autowired
    private AmiRepository amiRepository;

    @Override
    public Ami save(Ami ami) {
        return amiRepository.save(ami);
    }
}
