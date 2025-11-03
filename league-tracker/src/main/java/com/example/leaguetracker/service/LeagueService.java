package com.example.leaguetracker.service;

import com.example.leaguetracker.data.League;

public interface LeagueService {
    League create(League league);
    League get(Long id);
    Iterable<League> list();
    League update(Long id, League league);
    void delete(Long id);
}
