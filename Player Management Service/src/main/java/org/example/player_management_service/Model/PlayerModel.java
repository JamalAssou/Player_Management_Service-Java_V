package org.example.player_management_service.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@EqualsAndHashCode
@Setter
@Getter
@Entity
public class PlayerModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String pseudo;
    private String email;
    private int level;
    private int totalPoint;

    public PlayerModel(Long id, String name, String pseudo, String email, int level, int totalPoint) {
        this.id = id;
        this.name = name;
        this.pseudo = pseudo;
        this.email = email;
        this.level = level;
        this.totalPoint = totalPoint;
    }
}
