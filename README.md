# Football League Tracker

A simple Java Spring Boot project using multiple microservices to manage football leagues, teams, matches, and scores.
### Git repo
https://github.com/yorgo-haykal/football-league-tracker
---

## Services

| Service | Description | Port |
|----------|--------------|------|
| League | Manages leagues (name, country, season) | 8080 |
| Team | Manages teams and players | 8081 |
| Match | Manages matches (leagueId, homeTeamId, awayTeamId, date, status) | 8082 |
| Score | Tracks scores (homeGoals, awayGoals) | 8083 |

Each service has its own database and REST API.

---

## Run the Project

### Option 1 — IntelliJ IDEA
1. Open the project in IntelliJ.  
2. Run each module’s main class (`LeagueTrackerApplication`, `TeamServiceApplication`, etc.).  
3. Make sure each service has a unique port in `application.properties`.

### Option 2 — Terminal
```bash
./gradlew :league-service:bootRun
./gradlew :team-service:bootRun
./gradlew :match-service:bootRun
./gradlew :score-service:bootRun
```

## Initial Data

Each service loads example data automatically at startup:

- **Leagues:** Ligue 1 (France), Premier League (England)  
- **Teams:** PSG, Marseille, Liverpool  
- **Players:** Mbappé, Donnarumma (PSG)  
- **Matches:** PSG vs Marseille, Liverpool vs Marseille  
- **Scores:** start at 0–0  

---

##  Example Endpoints

You can test the APIs using **Postman** or **curl**.

### League Service
```bash
curl http://localhost:8080/api/leagues
```
### Team Service
```bash
curl http://localhost:8081/api/teams
```

### Match Service
```bash
curl http://localhost:8082/api/matches
```

### Score Service
```bash
curl http://localhost:8083/api/scores/1
curl -X POST http://localhost:8083/api/scores/1/home-goal
```
