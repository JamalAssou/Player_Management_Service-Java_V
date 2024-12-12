package org.example.player_management_service.Service;

import org.example.player_management_service.DAO.JoueurDAO;
import org.example.player_management_service.DTO.JoueurDTO;
import org.example.player_management_service.Model.Joueur;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class JoueurServiceTest {

    @InjectMocks
    private JoueurService joueurService;

    @Mock
    private JoueurDAO joueurDAO;

    @BeforeEach
    public void setUp() {
        // Initialisation des mocks si nécessaire
    }

    @Test
    public void testCreerJoueur() {
        JoueurDTO joueurDTO = new JoueurDTO();
        joueurDTO.setNom("John");
        joueurDTO.setPseudonyme("john123");
        joueurDTO.setEmail("john@example.com");
        joueurDTO.setNiveau(1);
        joueurDTO.setPointsTotaux(0);

        Joueur joueur = new Joueur();
        joueur.setId(1L);
        joueur.setNom("John");
        joueur.setPseudonyme("john123");

        when(joueurDAO.save(any(Joueur.class))).thenReturn(joueur);

        Joueur result = joueurService.creerJoueur(joueurDTO);

        assertEquals("John", result.getNom());
        assertEquals("john123", result.getPseudonyme());
    }

    @Test
    public void testTrouverJoueurParId() {
        Joueur joueur = new Joueur();
        joueur.setId(1L);
        joueur.setNom("John");
        joueur.setPseudonyme("john123");

        when(joueurDAO.findById(1L)).thenReturn(Optional.of(joueur));

        Joueur result = joueurService.trouverJoueurParId(1L);

        assertEquals("John", result.getNom());
        assertEquals("john123", result.getPseudonyme());
    }

    @Test
    public void testGetAllJoueurs() {
        List<Joueur> joueurs = new ArrayList<>();
        Joueur joueur1 = new Joueur();
        joueur1.setId(1L);
        joueur1.setNom("John");
        joueur1.setPseudonyme("john123");

        Joueur joueur2 = new Joueur();
        joueur2.setId(2L);
        joueur2.setNom("Jane");
        joueur2.setPseudonyme("jane456");

        joueurs.add(joueur1);
        joueurs.add(joueur2);

        when(joueurDAO.findAll()).thenReturn(joueurs);

        List<Joueur> result = joueurService.getAllJoueurs();

        assertEquals(2, result.size());
        assertEquals("John", result.get(0).getNom());
        assertEquals("john123", result.get(0).getPseudonyme());
        assertEquals("Jane", result.get(1).getNom());
        assertEquals("jane456", result.get(1).getPseudonyme());
    }

    @Test
    public void testUpdateJoueur() {
        JoueurDTO joueurDTO = new JoueurDTO();
        joueurDTO.setNom("John Updated");
        joueurDTO.setPseudonyme("john123updated");
        joueurDTO.setEmail("johnupdated@example.com");
        joueurDTO.setNiveau(2);
        joueurDTO.setPointsTotaux(100);

        Joueur joueur = new Joueur();
        joueur.setId(1L);
        joueur.setNom("John Updated");
        joueur.setPseudonyme("john123updated");

        when(joueurDAO.findById(1L)).thenReturn(Optional.of(joueur));
        when(joueurDAO.save(any(Joueur.class))).thenReturn(joueur);

        Joueur result = joueurService.updateJoueur(1L, joueurDTO);

        assertEquals("John Updated", result.getNom());
        assertEquals("john123updated", result.getPseudonyme());
    }

    @Test
    public void testDeleteJoueur() {
        Joueur joueur = new Joueur();
        joueur.setId(1L);

        when(joueurDAO.findById(1L)).thenReturn(Optional.of(joueur));

        joueurService.deleteJoueur(1L);

        // Vérifiez que le joueur a été supprimé (vous pouvez ajouter des vérifications supplémentaires si nécessaire)
    }
}
