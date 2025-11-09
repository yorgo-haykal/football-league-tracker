package com.example.scoreservice.repo;

import com.example.scoreservice.models.Score;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ScoreRepository extends JpaRepository<Score, Long> {
    Optional<Score> findByMatchId(Long matchId);
}