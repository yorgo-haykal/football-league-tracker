package com.oos.teams;

import com.oos.teams.domain.Player;
import com.oos.teams.repo.TeamRepository;
import com.oos.teams.repo.PlayerRepository;
import com.oos.teams.domain.Team;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TeamServiceApplication {
  public static void main(String[] args) {
    SpringApplication.run(TeamServiceApplication.class, args);
  }

    @Bean
    CommandLineRunner loadTeamsAndPlayers(TeamRepository teamRepo,
                                          PlayerRepository playerRepo) {
        return args -> {
            if (teamRepo.count() > 0) return;

            // Teams (match league IDs from league-service)
            Team psg = new Team();
            psg.setName("Paris SG");
            psg.setCode("PSG");
            psg.setLeagueId(1L);   // Ligue 1

            Team om = new Team();
            om.setName("Olympique Marseille");
            om.setCode("OM");
            om.setLeagueId(1L);    // Ligue 1

            Team liverpool = new Team();
            liverpool.setName("Liverpool");
            liverpool.setCode("LIV");
            liverpool.setLeagueId(2L); // Premier League

            psg = teamRepo.save(psg);          // id ~ 1
            om = teamRepo.save(om);            // id ~ 2
            liverpool = teamRepo.save(liverpool); // id ~ 3

            // Players for PSG
            Player p1 = new Player();
            p1.setFullName("Kylian Mbappé");
            p1.setTeamId(psg.getId());
            p1.setShirtNumber(7);
            p1.setPosition("FW");

            Player p2 = new Player();
            p2.setFullName("Gianluigi Donnarumma");
            p2.setTeamId(psg.getId());
            p2.setShirtNumber(99);
            p2.setPosition("GK");

            playerRepo.save(p1);
            playerRepo.save(p2);
        };
    }
}
