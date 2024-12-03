package org.example.player_management_service.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@Data
@Entity
public class Joueur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    @Column(nullable = false, unique = true)
    private String pseudonyme;

    @Column(nullable = false, unique = true)
    private String email;

    private int niveau;

    @Column(name = "points_totaux")
    private int pointsTotaux;

    @JsonIgnore//pour enlever l'erreur d'avoir plusierus fois les meme lignes
    // Relation bidirectionnelle (facultatif)
    @OneToMany(mappedBy = "joueur", cascade = CascadeType.ALL)
    private List<Ami> amis;

    @JsonIgnore
    @OneToMany(mappedBy = "ami", cascade = CascadeType.ALL)
    private List<Ami> amisInverse;
}

