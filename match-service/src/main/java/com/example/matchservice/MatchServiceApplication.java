package com.example.matchservice;

import com.example.matchservice.models.Match;
import com.example.matchservice.repo.MatchRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class MatchServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MatchServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner loadMatches(MatchRepository repo) {
        return args -> {
            if (repo.count() > 0) return;

            Match m1 = new Match();
            m1.setLeagueId(1L);    // Ligue 1
            m1.setHomeTeamId(1L);  // PSG
            m1.setAwayTeamId(2L);  // OM
            m1.setDate(LocalDate.of(2024, 11, 10));
            m1.setStatus("PENDING");

            Match m2 = new Match();
            m2.setLeagueId(2L);    // Premier League
            m2.setHomeTeamId(3L);  // Liverpool
            m2.setAwayTeamId(2L);  // OM (friendly)
            m2.setDate(LocalDate.of(2024, 11, 12));
            m2.setStatus("PENDING");

            repo.save(m1); // id ~ 1
            repo.save(m2); // id ~ 2
        };
    }
}
