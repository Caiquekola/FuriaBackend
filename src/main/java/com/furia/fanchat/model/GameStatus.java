package com.furia.fanchat.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "games_status")
public class GameStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String tournament;
    private String team1Name;
    private String team1Logo;
    private int team1Score;
    private String team2Name;
    private String team2Logo;
    private int team2Score;
    private String map;
    private int round;
    private String status;
}