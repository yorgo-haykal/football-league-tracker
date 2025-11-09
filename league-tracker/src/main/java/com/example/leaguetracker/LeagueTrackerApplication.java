package com.example.leaguetracker;

import com.example.leaguetracker.data.League;
import com.example.leaguetracker.data.LeagueRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LeagueTrackerApplication {

    public static void main(String[] args) {
        SpringApplication.run(LeagueTrackerApplication.class, args);
    }


    @Bean
    CommandLineRunner demo(LeagueRepository leagueRepository) {
        return args -> {
            if (leagueRepository.count() == 0) {
                League league1 = new League();
                league1.setName("Ligue 1");
                league1.setCountry("France");
                league1.setSeason("2025/2026");

                League league2 = new League();
                league2.setName("Premier League");
                league2.setCountry("England");
                league2.setSeason("2025/2026");

                leagueRepository.save(league1);
                leagueRepository.save(league2);
            }
        };
    }
}
