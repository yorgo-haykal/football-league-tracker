package com.oos.teams.repo;

import com.oos.teams.domain.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Long> {
  List<Player> findByTeamId(Long teamId);
  boolean existsByTeamIdAndShirtNumber(Long teamId, Integer shirtNumber);
}
