package org.scoreboard.domain;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class Match {

    private final String id;
    private final Team homeTeam;
    private final Team awayTeam;
    private int homeScore;
    private int awayScore;
    private final LocalDateTime startTime;

    public Match(Team homeTeam, Team awayTeam) {
        this.id = UUID.randomUUID().toString();
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeScore = 0;
        this.awayScore = 0;
        this.startTime = LocalDateTime.now();
    }

    public int getTotalScore() {
        return homeScore + awayScore;
    }

    public void updateScore(int homeScore, int awayScore) {
        this.homeScore = homeScore;
        this.awayScore = awayScore;
    }

    @Override
    public String toString() {
        return homeTeam + " " + homeScore + " - " + awayTeam + " " + awayScore;
    }
}
