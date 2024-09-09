package org.scoreboard.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.scoreboard.domain.Match;
import org.scoreboard.exception.IllegalScoreException;
import org.scoreboard.exception.MatchNotFoundException;
import org.scoreboard.service.Scoreboard;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static util.TeamFixture.*;

public class ScoreboardTest {

    public static final String INVALID_MATCH_ID = "XYZ";
    private Scoreboard scoreboardImpl;

    @Before
    public void setup() {
        scoreboardImpl = new ScoreboardImpl();
    }

    @Test
    public void shouldStartMatchAndReturnMatchId() {
        String matchId = scoreboardImpl.startMatch(TEAM_A, TEAM_B);
        assertNotNull(matchId);
    }

    @Test
    public void shouldReturnReportOfMatchesCurrentlyInProgress() {
        scoreboardImpl.startMatch(TEAM_A, TEAM_B);
        scoreboardImpl.startMatch(TEAM_C, TEAM_D);

        List<Match> matches = scoreboardImpl.getReport();
        assertEquals(2, matches.size());
    }

    @Test
    public void shouldUpdateScoreForTheMatch() {
        String matchId = scoreboardImpl.startMatch(TEAM_A, TEAM_B);
        scoreboardImpl.updateScore(matchId, 3, 2);

        List<Match> matches = scoreboardImpl.getReport();
        assertEquals(matchId, matches.getFirst().getId());
        assertEquals(5, matches.getFirst().getTotalScore());
    }

    @Test(expected = IllegalScoreException.class)
    public void shouldThrowExceptionWhenNegativeScoreForHomeTeam() {
        String matchId = scoreboardImpl.startMatch(TEAM_A, TEAM_B);
        scoreboardImpl.updateScore(matchId, -1, 2);
    }

    @Test(expected = IllegalScoreException.class)
    public void shouldThrowExceptionWhenNegativeScoreForAwayTeam() {
        String matchId = scoreboardImpl.startMatch(TEAM_A, TEAM_B);
        scoreboardImpl.updateScore(matchId, 1, -2);
    }

    @Test(expected = MatchNotFoundException.class)
    public void shouldThrowExceptionWhenUpdatingScoreForNonExistingMatch() {
        scoreboardImpl.updateScore(INVALID_MATCH_ID, 3, 2);
    }

    @Test
    public void shouldFinishMatch() {
        String matchId1 = scoreboardImpl.startMatch(TEAM_A, TEAM_B);
        scoreboardImpl.finishMatch(matchId1);
        List<Match> matches = scoreboardImpl.getReport();
        assertEquals(0, matches.size());
    }

    @Test(expected = MatchNotFoundException.class)
    public void shouldThrowAnExceptionWhenFinishingNonExistingMatch() {
        scoreboardImpl.finishMatch(INVALID_MATCH_ID);
    }
}