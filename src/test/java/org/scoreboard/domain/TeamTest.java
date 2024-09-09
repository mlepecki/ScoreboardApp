package org.scoreboard.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TeamTest {


    public static final Team TEAM_A = new Team("Team A");
    public static final Team TEAM_B = new Team("Team B");

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
