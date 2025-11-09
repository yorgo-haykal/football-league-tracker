package com.example.scoreservice;

import com.example.scoreservice.models.Score;
import com.example.scoreservice.repo.ScoreRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ScoreServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScoreServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner loadScores(ScoreRepository repo) {
        return args -> {
            if (repo.count() > 0) return;

            // Example: match 1 finished 2–1
            Score s1 = new Score();
            s1.setMatchId(1L);
            s1.setHomeGoals(2);
            s1.setAwayGoals(1);

            repo.save(s1);
        };
    }
}
