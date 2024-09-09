package org.scoreboard.domain;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class MatchTest {

    private Match match;
    private Team homeTeam;
    private Team awayTeam;

    @Before
    public void setUp() {
        homeTeam = Mockito.mock(Team.class);
        awayTeam = Mockito.mock(Team.class);

        match = new Match(homeTeam, awayTeam);
    }

    @Test
    public void shouldInitializeConstructorCorrectly() {
        assertNotNull(match);
        assertNotNull(match.toString());
        assertEquals(0, match.getTotalScore());
// skipping below verifier, id doesn`t make sense to stub toString() method
//        verify(homeTeam, never()).toString();
//        verify(awayTeam, never()).toString();
    }

    @Test
    public void shouldInitializeTotalScoreCorrectly() {
        assertEquals(0, match.getTotalScore());
    }

    @Test
    public void shouldUpdateScore() {
        match.updateScore(3, 2);
        assertEquals(5, match.getTotalScore());
    }

    @Test
    public void shouldReturnStringWithProperFormat() {
        when(homeTeam.toString()).thenReturn("Team A");
        when(awayTeam.toString()).thenReturn("Team B");

        match.updateScore(3, 2);

        assertEquals("Team A 3 - Team B 2", match.toString());
    }

    @Test
    public void shouldReturnStringAfterCallingToStringWithResult() {
        when(homeTeam.toString()).thenReturn("Team A");
        when(awayTeam.toString()).thenReturn("Team B");

        assertEquals("Team A 0 - Team B 0", match.toString());
    }

    @Test
    public void shouldGenerateMatchIdWhenCreatingMatchObject() {
        String matchId = match.getId();
        assertNotNull(matchId);
        assertFalse(matchId.isEmpty());
    }

    @Test
    public void shouldSetProperStartTimeWhenCreatingMatchObject() {
        LocalDateTime startTime = match.getStartTime();
        assertNotNull(startTime);
        assertTrue(startTime.isBefore(LocalDateTime.now()) || startTime.isEqual(LocalDateTime.now()));
    }
}