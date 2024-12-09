package org.example.player_management_service.Controller;

import org.example.player_management_service.DTO.JoueurDTO;
import org.example.player_management_service.Model.Joueur;
import org.example.player_management_service.Service.JoueurService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class JoueurControllerTest {

    @InjectMocks
    private JoueurController joueurController;

    @Mock
    private JoueurService joueurService;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(joueurController).build();
    }

    @Test
    public void testCreerJoueur() throws Exception {
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

        when(joueurService.creerJoueur(joueurDTO)).thenReturn(joueur);

        mockMvc.perform(post("/joueurs")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"nom\":\"John\", \"pseudonyme\":\"john123\", \"email\":\"john@example.com\", \"niveau\":1, \"pointsTotaux\":0}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.nom").value("John"))
                .andExpect(jsonPath("$.pseudonyme").value("john123"));
    }

    @Test
    public void testObtenirJoueur() throws Exception {
        Joueur joueur = new Joueur();
        joueur.setId(1L);
        joueur.setNom("John");
        joueur.setPseudonyme("john123");

        when(joueurService.trouverJoueurParId(1L)).thenReturn(joueur);

        mockMvc.perform(get("/joueurs/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nom").value("John"))
                .andExpect(jsonPath("$.pseudonyme").value("john123"));
    }

    @Test
    public void testGetAllJoueurs() throws Exception {
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

        when(joueurService.getAllJoueurs()).thenReturn(joueurs);

        mockMvc.perform(get("/joueurs"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nom").value("John"))
                .andExpect(jsonPath("$[0].pseudonyme").value("john123"))
                .andExpect(jsonPath("$[1].nom").value("Jane"))
                .andExpect(jsonPath("$[1].pseudonyme").value("jane456"));
    }

    @Test
    public void testUpdateJoueur() throws Exception {
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

        when(joueurService.updateJoueur(1L, joueurDTO)).thenReturn(joueur);

        mockMvc.perform(put("/joueurs/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"nom\":\"John Updated\", \"pseudonyme\":\"john123updated\", \"email\":\"johnupdated@example.com\", \"niveau\":2, \"pointsTotaux\":100}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nom").value("John Updated"))
                .andExpect(jsonPath("$.pseudonyme").value("john123updated"));
    }

    @Test
    public void testDeleteJoueur() throws Exception {
        mockMvc.perform(delete("/joueurs/1"))
                .andExpect(status().isOk());
    }
}
