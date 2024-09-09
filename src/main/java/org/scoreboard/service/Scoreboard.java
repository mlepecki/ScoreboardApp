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
     * Method return report of the matches. Matches are sorted in the following order:
     * - first, matches with the highest total score
     * - when total score is equal, then recently started matches are first
     * @return - sorted summary of the matches
     */
    List<Match> getReport();

    /**
     * This method is updating match score. When provided number is negative, then {@link org.scoreboard.exception.IllegalScoreException} is thrown.
     * When match is not find, then {@link org.scoreboard.exception.MatchNotFoundException} will be thrown
     * @param matchId
     * @param homeScore
     * @param awayScore
     */
    void updateScore(String matchId, int homeScore, int awayScore);

    /**
     * This method is finishing the match. When match is not find, then {@link org.excercise.exception.MatchNotFoundException} will be thrown
     * @param matchId
     */
    void finishMatch(String matchId);

}
