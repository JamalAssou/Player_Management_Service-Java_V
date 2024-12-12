package org.example.player_management_service.Service;

import org.example.player_management_service.DAO.AmiDAO;
import org.example.player_management_service.DAO.JoueurDAO;
import org.example.player_management_service.Model.Ami;
import org.example.player_management_service.Model.Joueur;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AmiServiceTest {

    @InjectMocks
    private AmiService amiService;

    @Mock
    private JoueurDAO joueurDAO;

    @Mock
    private AmiDAO amiDAO;

    @BeforeEach
    public void setUp() {
        // Initialisation des mocks si nécessaire
    }

    @Test
    public void testAjouterAmi() {
        Joueur joueur = new Joueur();
        joueur.setId(1L);
        when(joueurDAO.findById(1L)).thenReturn(Optional.of(joueur));

        Ami ami = new Ami();
        ami.setId(2L);
        ami.setJoueur(joueur);
        when(amiDAO.save(ami)).thenReturn(ami);

        Ami result = amiService.ajouterAmi(1L, 2L);

        assertEquals(2L, result.getId());
    }

    @Test
    public void testObtenirAmis() {
        Joueur joueur = new Joueur();
        joueur.setId(1L);

        Ami ami1 = new Ami();
        ami1.setId(2L);
        ami1.setJoueur(joueur);

        Ami ami2 = new Ami();
        ami2.setId(3L);
        ami2.setJoueur(joueur);

        joueur.setAmis(List.of(ami1, ami2));

        when(joueurDAO.findById(1L)).thenReturn(Optional.of(joueur));

        List<Ami> result = amiService.obtenirAmis(1L);

        assertEquals(2, result.size());
        assertEquals(2L, result.get(0).getId());
        assertEquals(3L, result.get(1).getId());
    }
}
