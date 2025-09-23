package com.oos.teams.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Table(
  name = "players",
  indexes = @Index(name = "idx_player_team", columnList = "team_id")
)
public class Player {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Size(max = 100)
  private String fullName;

  @NotNull
  @Column(name = "team_id", nullable = false)
  private Long teamId;

  @Min(1) @Max(99)
  private Integer shirtNumber;

  @PastOrPresent
  private LocalDate birthDate;

  @Size(max = 40)
  private String position; // GK, DF, MF, FW

  // getters/setters
  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }

  public String getFullName() { return fullName; }
  public void setFullName(String fullName) { this.fullName = fullName; }

  public Long getTeamId() { return teamId; }
  public void setTeamId(Long teamId) { this.teamId = teamId; }

  public Integer getShirtNumber() { return shirtNumber; }
  public void setShirtNumber(Integer shirtNumber) { this.shirtNumber = shirtNumber; }

  public LocalDate getBirthDate() { return birthDate; }
  public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }

  public String getPosition() { return position; }
  public void setPosition(String position) { this.position = position; }
}
