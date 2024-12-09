package org.example.player_management_service.Service;

import org.example.player_management_service.Model.Ami;
import org.example.player_management_service.Model.Joueur;
import org.example.player_management_service.Repository.AmiRepository;
import org.example.player_management_service.Repository.JoueurRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AmiServiceTest {

    @InjectMocks
    private AmiService amiService;

    @Mock
    private JoueurRepository joueurRepository;

    @Mock
    private AmiRepository amiRepository;

    public AmiServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAjouterAmi() {
        Joueur joueur = new Joueur();
        joueur.setId(1L);
        when(joueurRepository.findById(1L)).thenReturn(Optional.of(joueur));

        Ami ami = new Ami();
        ami.setId(2L);
        ami.setJoueur(joueur);
        when(amiRepository.save(ami)).thenReturn(ami);

        Ami result = amiService.ajouterAmi(1L, 2L);

        assertEquals(2L, result.getId());
    }
    @Test
    public void testObtenirAmis() {
        // Préparer les données de test
        Joueur joueur = new Joueur();
        joueur.setId(1L);

        Ami ami1 = new Ami();
        ami1.setId(2L);
        ami1.setJoueur(joueur);

        Ami ami2 = new Ami();
        ami2.setId(3L);
        ami2.setJoueur(joueur);

        List<Ami> amis = new ArrayList<>();
        amis.add(ami1);
        amis.add(ami2);

        joueur.setAmis(amis);

        // Définir le comportement des mocks
        when(joueurRepository.findById(1L)).thenReturn(Optional.of(joueur));

        // Appeler la méthode à tester
        List<Ami> result = amiService.obtenirAmis(1L);

        // Vérifier les résultats
        assertEquals(2, result.size());
        assertEquals(2L, result.get(0).getId());
        assertEquals(3L, result.get(1).getId());
    }
}
