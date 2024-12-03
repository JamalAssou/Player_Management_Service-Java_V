package org.example.player_management_service.Controller;

import org.example.player_management_service.Model.Joueur;
import org.example.player_management_service.Service.JoueurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/joueurs")
public class JoueurController {

    @Autowired
    private JoueurService joueurService;

    @PostMapping
    public ResponseEntity<Joueur> creerJoueur(@RequestBody Joueur joueur) {
        return ResponseEntity.status(HttpStatus.CREATED).body(joueurService.creerJoueur(joueur));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Joueur> obtenirJoueur(@PathVariable Long id) {
        return ResponseEntity.ok(joueurService.trouverJoueurParId(id));
    }

    @GetMapping
    public List<Joueur> getAllJoueurs() {
        return joueurService.getAllJoueurs();
    }

    @PutMapping("/{id}")
    public Joueur updateJoueur(@PathVariable Long id, @RequestBody Joueur joueur) {
        return joueurService.updateJoueur(id, joueur);
    }

    @DeleteMapping("/{id}")
    public void deleteJoueur(@PathVariable Long id) {
        joueurService.deleteJoueur(id);
    }

}

