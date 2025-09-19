package com.example.footballleaguetracker;

import com.example.footballleaguetracker.data.League;
import com.example.footballleaguetracker.data.LeagueRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FootballLeagueTrackerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FootballLeagueTrackerApplication.class, args);
    }

    @Bean
    CommandLineRunner demo(LeagueRepository leagueRepository) {
        return args -> {
            League league1 = new League();
            league1.setName("Ligue 1");
            league1.setCountry("France");
            league1.setSeason("2025/2026");
            leagueRepository.save(league1);
        };
    }
}
