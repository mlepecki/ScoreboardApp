package org.scoreboard.service.impl;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static util.TeamFixture.TEAM_A;
import static util.TeamFixture.TEAM_B;

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
}