package com.oos.teams.api;

import com.oos.teams.domain.Player;
import com.oos.teams.service.impl.PlayerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {
  private final PlayerService service;
  public PlayerController(PlayerService service){ this.service = service; }

  @PostMapping @ResponseStatus(HttpStatus.CREATED)
  public Player create(@Valid @RequestBody Player p){ return service.create(p); }

  @GetMapping("/{id}") public Player get(@PathVariable Long id){ return service.get(id); }

  @GetMapping public List<Player> list(@RequestParam Long teamId){
    return service.listByTeam(teamId);
  }

  @PutMapping("/{id}") public Player update(@PathVariable Long id, @Valid @RequestBody Player p){
    return service.update(id, p);
  }

  @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable Long id){ service.delete(id); }
}
