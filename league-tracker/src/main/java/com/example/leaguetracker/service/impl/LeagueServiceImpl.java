package com.example.leaguetracker.service.impl;

import com.example.leaguetracker.data.League;
import com.example.leaguetracker.data.LeagueRepository;
import com.example.leaguetracker.service.LeagueService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeagueServiceImpl implements LeagueService {
    private final LeagueRepository leagueRepository;

    public LeagueServiceImpl(LeagueRepository leagueRepository) {
        this.leagueRepository = leagueRepository;
    }

    public League create(League league) {
        return leagueRepository.save(league);
    }

    public League get(Long id) {
        return leagueRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("League not found"));
    }

    public List<League> list() {
        return (List<League>) leagueRepository.findAll();
    }

    public League update(Long id, League league) {
        League existing = leagueRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("League not found"));
        league.setId(existing.getId());
        return leagueRepository.save(league);
    }

    public void delete(Long id) {
        if (!leagueRepository.existsById(id)) {
            throw new IllegalArgumentException("League not found");
        }
        leagueRepository.deleteById(id);
    }
}
