package com.oos.teams.service.impl;

import com.oos.teams.domain.Player;
import com.oos.teams.repo.PlayerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service @Transactional
public class PlayerService {
  private final PlayerRepository repo;
  public PlayerService(PlayerRepository repo){ this.repo = repo; }

  public Player create(Player p){
    if (p.getShirtNumber()!=null &&
        repo.existsByTeamIdAndShirtNumber(p.getTeamId(), p.getShirtNumber()))
      throw new IllegalArgumentException("Shirt number already used in this team");
    return repo.save(p);
  }

  public Player get(Long id){
    return repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Player not found"));
  }

  public List<Player> listByTeam(Long teamId){
    return repo.findByTeamId(teamId);
  }

  public Player update(Long id, Player p){
    Player cur = get(id);
    if (p.getShirtNumber()!=null && !p.getShirtNumber().equals(cur.getShirtNumber())
        && repo.existsByTeamIdAndShirtNumber(p.getTeamId(), p.getShirtNumber()))
      throw new IllegalArgumentException("Shirt number already used in this team");
    cur.setFullName(p.getFullName());
    cur.setTeamId(p.getTeamId());
    cur.setShirtNumber(p.getShirtNumber());
    cur.setBirthDate(p.getBirthDate());
    cur.setPosition(p.getPosition());
    return repo.save(cur);
  }

  public void delete(Long id){ repo.deleteById(id); }
}
