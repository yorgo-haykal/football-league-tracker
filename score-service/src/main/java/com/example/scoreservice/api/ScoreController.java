package com.example.scoreservice.api;

import com.example.scoreservice.models.Score;
import com.example.scoreservice.service.ScoreService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/scores")
public class ScoreController {

    private final ScoreService service;

    public ScoreController(ScoreService service) {
        this.service = service;
    }

    // GET /api/scores/{matchId}
    @GetMapping("/{matchId}")
    public Score getScore(@PathVariable Long matchId) {
        return service.getScore(matchId);
    }

    // POST /api/scores/{matchId}/home-goal
    @PostMapping("/{matchId}/home-goal")
    @ResponseStatus(HttpStatus.OK)
    public Score addHomeGoal(@PathVariable Long matchId) {
        return service.addHomeGoal(matchId);
    }

    // POST /api/scores/{matchId}/away-goal
    @PostMapping("/{matchId}/away-goal")
    @ResponseStatus(HttpStatus.OK)
    public Score addAwayGoal(@PathVariable Long matchId) {
        return service.addAwayGoal(matchId);
    }
}
