package org.scoreboard.service.impl;

import org.scoreboard.domain.Match;
import org.scoreboard.domain.Team;
import org.scoreboard.exception.IllegalScoreException;
import org.scoreboard.exception.MatchNotFoundException;
import org.scoreboard.service.Scoreboard;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

class ScoreboardImpl implements Scoreboard {
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
        matchesInProgress.sort(Comparator
                .comparingInt(Match::getTotalScore)
                .thenComparing(Match::getStartTime)
                .reversed());

        return matchesInProgress;
    }

    @Override
    public void updateScore(String matchId, int homeScore, int awayScore) {
        final Optional<Match> match = findMatchById(matchId);
        if (match.isPresent()) {
            if (homeScore < 0 || awayScore < 0) {
                throw new IllegalScoreException("Scores cannot be negative.");
            }
            match.get().updateScore(homeScore, awayScore);
        } else {
            throw new MatchNotFoundException("Match with ID " + matchId + " not found.");
        }
    }


    private Optional<Match> findMatchById(String matchId) {
        return matchesInProgress.stream()
                .filter(match -> match.getId().equals(matchId))
                .findFirst();
    }

    public void finishMatch(String matchId) {
        boolean matchRemoved = matchesInProgress.removeIf(match -> match.getId().equals(matchId));
        if (!matchRemoved) {
            throw new MatchNotFoundException("Match with ID " + matchId + " not found.");
        }
    }
}
