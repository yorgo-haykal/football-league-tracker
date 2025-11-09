package com.example.scoreservice.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(
        name = "scores",
        uniqueConstraints = @UniqueConstraint(columnNames = "match_id")
)
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "match_id", nullable = false)
    private Long matchId;   // reference to Match service

    @Min(0)
    @Column(name = "home_goals", nullable = false)
    private int homeGoals = 0;

    @Min(0)
    @Column(name = "away_goals", nullable = false)
    private int awayGoals = 0;

    // getters/setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getMatchId() { return matchId; }
    public void setMatchId(Long matchId) { this.matchId = matchId; }

    public int getHomeGoals() { return homeGoals; }
    public void setHomeGoals(int homeGoals) { this.homeGoals = homeGoals; }

    public int getAwayGoals() { return awayGoals; }
    public void setAwayGoals(int awayGoals) { this.awayGoals = awayGoals; }

}
