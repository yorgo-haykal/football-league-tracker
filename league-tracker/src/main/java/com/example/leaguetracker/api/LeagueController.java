package com.example.leaguetracker.api;

import com.example.leaguetracker.data.League;
import com.example.leaguetracker.service.LeagueService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/leagues")
public class LeagueController {
    private final LeagueService leagueService;

    public LeagueController(LeagueService leagueService) {
        this.leagueService = leagueService;
    }

    @GetMapping
    public Iterable<League> getLeagues() {
        return leagueService.list();
    }

    @GetMapping("/{id}")
    public League getLeague(@PathVariable Long id) {
        return leagueService.get(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public League createLeague(@RequestBody @Valid League league) {
        return leagueService.create(league);
    }

    @PutMapping("/{id}")
    public League updateLeague(@PathVariable Long id, @RequestBody @Valid League league) {
        return leagueService.update(id, league);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLeague(@PathVariable Long id) {
        leagueService.delete(id);
    }
}