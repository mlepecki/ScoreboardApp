package org.scoreboard.service.impl;

import org.scoreboard.domain.Match;
import org.scoreboard.domain.Team;
import org.scoreboard.service.Scoreboard;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ScoreboardImpl implements Scoreboard {
    private final List<Match> matchesInProgress;

    public ScoreboardImpl() {
        this.matchesInProgress = new ArrayList<>();
    }

    @Override
    public String startMatch(Team homeTeam, Team awayTeam) {
        final Match newMatch = new Match(homeTeam, awayTeam);
        matchesInProgress.add(newMatch);
        return newMatch.getId();
    }

    public List<Match> getReport() {
        return matchesInProgress;
    }
}
