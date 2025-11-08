package com.example.matchservice.service;

import com.example.matchservice.models.Match;

public interface MatchService {
    Match create(Match match);
    Match get(Long id);
    Iterable<Match> list();
    Match update(Long id, Match match);
    void delete(Long id);
}
