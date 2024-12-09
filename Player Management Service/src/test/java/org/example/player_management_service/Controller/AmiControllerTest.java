package org.example.player_management_service.Controller;

import org.example.player_management_service.Model.Ami;
import org.example.player_management_service.Service.AmiService;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class AmiControllerTest {

    @Mock
    private AmiService amiService;

    @InjectMocks
    private AmiController amiController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(amiController).build();
    }

    @Test
    public void testAjouterAmi() throws Exception {
        mockMvc.perform(post("/joueurs/1/amis")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"idAmi\":2}"))
                .andExpect(status().isCreated());
    }

    @Test
    public void testObtenirAmis() throws Exception {
        List<Ami> amis = new ArrayList<>();
        Ami ami = new Ami();
        ami.setId(2L);
        amis.add(ami);

        when(amiService.obtenirAmis(2L)).thenReturn(amis);

        mockMvc.perform(get("/joueurs/2/amis"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(2)); // Ajustez le chemin JSON ici
    }
}
