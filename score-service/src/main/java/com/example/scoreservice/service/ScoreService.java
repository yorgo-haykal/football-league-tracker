package com.example.scoreservice.service;

import com.example.scoreservice.models.Score;
import com.example.scoreservice.repo.ScoreRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ScoreService {

    private final ScoreRepository repo;

    public ScoreService(ScoreRepository repo) {
        this.repo = repo;
    }

    private Score getOrCreate(Long matchId) {
        return repo.findByMatchId(matchId).orElseGet(() -> {
            Score s = new Score();
            s.setMatchId(matchId);
            s.setHomeGoals(0);
            s.setAwayGoals(0);
            return repo.save(s);
        });
    }

    public Score getScore(Long matchId) {
        return getOrCreate(matchId);
    }

    public Score addHomeGoal(Long matchId) {
        Score s = getOrCreate(matchId);
        s.setHomeGoals(s.getHomeGoals() + 1);
        return repo.save(s);
    }

    public Score addAwayGoal(Long matchId) {
        Score s = getOrCreate(matchId);
        s.setAwayGoals(s.getAwayGoals() + 1);
        return repo.save(s);
    }
}