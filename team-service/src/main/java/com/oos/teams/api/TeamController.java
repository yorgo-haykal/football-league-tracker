package com.oos.teams.api;

import com.oos.teams.domain.Team;
import com.oos.teams.service.impl.TeamService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/teams")
public class TeamController {
  private final TeamService service;
  public TeamController(TeamService service){ this.service = service; }

  @PostMapping @ResponseStatus(HttpStatus.CREATED)
  public Team create(@Valid @RequestBody Team t){ return service.create(t); }

  @GetMapping("/{id}") public Team get(@PathVariable Long id){ return service.get(id); }

  @GetMapping public List<Team> list(@RequestParam(required=false) Long leagueId){
    return service.list(leagueId);
  }

  @PutMapping("/{id}") public Team update(@PathVariable Long id, @Valid @RequestBody Team t){
    return service.update(id, t);
  }

  @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable Long id){ service.delete(id); }
}
