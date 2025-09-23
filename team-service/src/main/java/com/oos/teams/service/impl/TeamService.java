package com.oos.teams.service.impl;

import com.oos.teams.domain.Team;
import com.oos.teams.repo.TeamRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service @Transactional
public class TeamService {
  private final TeamRepository repo;
  public TeamService(TeamRepository repo){ this.repo = repo; }

  public Team create(Team t){
    if (repo.existsByNameAndLeagueId(t.getName(), t.getLeagueId()))
      throw new IllegalArgumentException("Team already exists in this league");
    return repo.save(t);
  }

  public Team get(Long id){
    return repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Team not found"));
  }

  public List<Team> list(Long leagueId){
    return leagueId == null ? repo.findAll() : repo.findByLeagueId(leagueId);
  }

  public Team update(Long id, Team t){
    Team cur = get(id);
    cur.setName(t.getName());
    cur.setLeagueId(t.getLeagueId());
    cur.setCode(t.getCode());
    return repo.save(cur);
  }

  public void delete(Long id){ repo.deleteById(id); }
}
