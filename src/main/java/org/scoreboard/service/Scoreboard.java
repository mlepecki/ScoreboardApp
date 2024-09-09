package org.scoreboard.service;

import org.scoreboard.domain.Match;
import org.scoreboard.domain.Team;

import java.util.List;

public interface Scoreboard {
    /**
     * This method is start the match with start time LocalDateTime.now() and generates unique identifier matchID
     * @param homeTeam
     * @param awayTeam
     * @return matchID - unique identifier for specific match
     */
    String startMatch(Team homeTeam, Team awayTeam);

    /**
     * Method return report of the matches currently in progress
     * @return - List of matches currently in progress
     */
    List<Match> getReport();
}
