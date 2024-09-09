package org.scoreboard.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static util.TeamFixture.TEAM_A;
import static util.TeamFixture.TEAM_B;

//In my opinion below tests can be skip because we will test it during main class testing

public class TeamTest {

    @Test
    public void testsCompareTwoTeams() {
        assertNotEquals(TEAM_A, TEAM_B);
    }

    @Test
    public void testsCompareTwoTeamsWhenOneIsNull() {
        assertNotEquals(TEAM_A, null);
    }

    @Test
    public void testsCompareSameTeam() {
        Team teamB = TEAM_A;
        assertEquals(TEAM_A, teamB);
    }

}
