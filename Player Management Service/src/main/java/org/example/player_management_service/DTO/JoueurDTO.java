package org.example.player_management_service.DTO;

import lombok.Data;

@Data
public class JoueurDTO {
    private String nom;
    private String pseudonyme;
    private String email;
    private int niveau;
    private int pointsTotaux;
}
