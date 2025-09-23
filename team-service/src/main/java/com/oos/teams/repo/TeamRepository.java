package com.oos.teams.repo;

import com.oos.teams.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Long> {
  List<Team> findByLeagueId(Long leagueId);
  boolean existsByNameAndLeagueId(String name, Long leagueId);
}
