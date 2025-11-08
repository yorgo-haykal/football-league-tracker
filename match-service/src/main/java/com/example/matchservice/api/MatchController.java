package com.example.matchservice.api;

import com.example.matchservice.models.Match;
import com.example.matchservice.service.MatchService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/matches")
public class MatchController {

    private final MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    // GET /api/matches
    @GetMapping
    public Iterable<Match> getMatches() {
        return matchService.list();
    }

    // GET /api/matches/{id}
    @GetMapping("/{id}")
    public Match getMatch(@PathVariable Long id) {
        return matchService.get(id);
    }

    // POST /api/matches
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Match createMatch(@RequestBody Match match) {
        // later you can add validation: leagueId, homeTeamId, awayTeamId via HTTP calls
        return matchService.create(match);
    }

    // PUT /api/matches/{id}
    @PutMapping("/{id}")
    public Match updateMatch(@PathVariable Long id, @RequestBody Match match) {
        return matchService.update(id, match);
    }

    // DELETE /api/matches/{id}
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMatch(@PathVariable Long id) {
        matchService.delete(id);
    }
}