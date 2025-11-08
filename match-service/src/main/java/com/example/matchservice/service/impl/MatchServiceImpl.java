package com.example.matchservice.service.impl;

import com.example.matchservice.models.Match;
import com.example.matchservice.repo.MatchRepository;
import com.example.matchservice.service.MatchService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchServiceImpl implements MatchService {
    private final MatchRepository matchRepository;

    public MatchServiceImpl(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public Match create(Match match) {
        return matchRepository.save(match);
    }

    public Match get(Long id) {
        return matchRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Match not found"));
    }

    public List<Match> list() {
        return matchRepository.findAll();
    }

    public Match update(Long id, Match data) {
        Match existing = matchRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Match not found"));

        existing.setLeagueId(data.getLeagueId());
        existing.setHomeTeamId(data.getHomeTeamId());
        existing.setAwayTeamId(data.getAwayTeamId());
        existing.setDate(data.getDate());
        existing.setStatus(data.getStatus());

        return matchRepository.save(existing);
    }

    public void delete(Long id) {
        if (!matchRepository.existsById(id)) {
            throw new IllegalArgumentException("Match not found");
        }
        matchRepository.deleteById(id);
    }
}
