package org.scoreboard.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.scoreboard.domain.Match;
import org.scoreboard.service.Scoreboard;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static util.TeamFixture.*;

public class ScoreboardTest {

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

}