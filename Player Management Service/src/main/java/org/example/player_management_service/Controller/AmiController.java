package org.example.player_management_service.Controller;

import org.example.player_management_service.Model.Ami;
import org.example.player_management_service.Model.Joueur;
import org.example.player_management_service.Service.AmiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/amis") // Base URL pour ce contrôleur
public class AmiController {

    @Autowired
    private AmiService amiService;

    // Ajouter un ami pour un joueur donné
    @PostMapping("/{id}/add/{idAmi}")
    public Ami addAmi(@PathVariable Long id, @PathVariable Long idAmi) {//j'ai changer le @requestBody en @PathVariable car il n'arrive pas a parser le Json en Long...
        return amiService.addAmi(id, idAmi);
    }

    // Récupérer tous les amis d'un joueur donné
    @GetMapping("/{id}/list")
    public List<Joueur> getAmis(@PathVariable Long id) {
        return amiService.getAmis(id);
    }
}
