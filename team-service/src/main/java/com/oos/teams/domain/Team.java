package com.oos.teams.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(
  name = "teams",
  uniqueConstraints = @UniqueConstraint(columnNames = {"name", "league_id"})
)
public class Team {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Size(max = 80)
  private String name;

  @NotNull
  @Column(name = "league_id", nullable = false)
  private Long leagueId; // référence logique vers la League (service 8080)

  @Size(max = 3)
  private String code;   // ex: PSG, RMA, OL

  // getters/setters
  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }

  public String getName() { return name; }
  public void setName(String name) { this.name = name; }

  public Long getLeagueId() { return leagueId; }
  public void setLeagueId(Long leagueId) { this.leagueId = leagueId; }

  public String getCode() { return code; }
  public void setCode(String code) { this.code = code; }
}
