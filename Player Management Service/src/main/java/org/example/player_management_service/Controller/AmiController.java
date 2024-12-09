package org.example.player_management_service.Controller;

import org.example.player_management_service.DTO.AmiDTO;
import org.example.player_management_service.Model.Ami;
import org.example.player_management_service.Service.AmiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/joueurs")
public class AmiController {

    @Autowired
    private AmiService amiService;

    @PostMapping("/{joueurId}/amis")
    public ResponseEntity<Ami> ajouterAmi(@PathVariable Long joueurId, @RequestBody AmiDTO amiDTO) {
        Ami ami = amiService.ajouterAmi(joueurId, amiDTO.getIdAmi());
        return ResponseEntity.status(HttpStatus.CREATED).body(ami);
    }

    @GetMapping("/{joueurId}/amis")
    public ResponseEntity<List<Ami>> getAmis(@PathVariable Long joueurId) {
        List<Ami> amis = amiService.obtenirAmis(joueurId);
        return ResponseEntity.ok(amis);
    }
}

// Ajouter un ami pour un joueur donné
    /*@PostMapping("/{id}/add/{idAmi}")
    public Ami addAmi(@PathVariable Long id, @PathVariable Long idAmi) {//j'ai changer le @requestBody en @PathVariable car il n'arrive pas a parser le Json en Long...
        return amiService.addAmi(id, idAmi);
    }*/