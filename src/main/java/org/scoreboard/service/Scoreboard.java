package org.scoreboard.service;

import org.scoreboard.domain.Team;

public interface Scoreboard {
    /**
     * This method is start the match with start time LocalDateTime.now() and generates unique identifier matchID
     * @param homeTeam
     * @param awayTeam
     * @return matchID - unique identifier for specific match
     */
    String startMatch(Team homeTeam, Team awayTeam);
}
