package org.example.player_management_service.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data // Génère les getters, setters, toString, equals et hashCode grace a Lombok
@Table(name = "ami")
public class Ami {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore//pour enlever l'erreur d'avoir plusierus fois les meme lignes
    @ManyToOne
    @JoinColumn(name = "id_joueur", nullable = false)
    private Joueur joueur;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_ami", nullable = false)
    private Joueur ami;
}
