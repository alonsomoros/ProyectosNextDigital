package org.example;


import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {

    private TennisGame tennisGame;

    @BeforeEach
    public void setUp() {
        tennisGame = new TennisGame();
    }

    // Basic Scoring

    @Test
    public void shouldReturnLoveLove_OnStart(){
        String score = tennisGame.getScore();

        assertEquals("Love-Love",score);
    }

    @Test
    public void testPlayerOneScoresOnce_ShouldBeFifteenLove(){
        tennisGame = new TennisGame();

        tennisGame.playerOneScores();

        String score = tennisGame.getScore();
        assertEquals("Fifteen-Love",score);
    }

    @Test
    public void testPlayerTwoScoresOnce_ShouldBeLoveFifteen(){
        tennisGame = new TennisGame();

        tennisGame.playerTwoScores();

        String score = tennisGame.getScore();
        assertEquals("Love-Fifteen",score);
    }

    @Test
    public void testBothPlayersScoreOnce_ShouldBeFifteenAll(){
        tennisGame = new TennisGame();

        tennisGame.playerOneScores();

        tennisGame.playerTwoScores();

        String score = tennisGame.getScore();
        assertEquals("Fifteen-All",score);
    }

    @Test
    public void testPlayerOneScoresTwice_ShouldBeThirtyLove(){
        tennisGame = new TennisGame();

        tennisGame.playerOneScores();
        tennisGame.playerOneScores();

        String score = tennisGame.getScore();
        assertEquals("Thirty-Love",score);
    }

    @Test
    public void testPlayerTwoScoresTwice_ShouldBeLoveThirty() {
        tennisGame = new TennisGame();

        tennisGame.playerTwoScores();
        tennisGame.playerTwoScores();

        String score = tennisGame.getScore();
        assertEquals("Love-Thirty", score);
    }

    // Deuce and Advantage

    @Test
    public void testScoreIsFortyAll_ShouldBeDeuce(){
        tennisGame = new TennisGame();

        tennisGame.playerOneScores();
        tennisGame.playerOneScores();
        tennisGame.playerOneScores();

        tennisGame.playerTwoScores();
        tennisGame.playerTwoScores();
        tennisGame.playerTwoScores();

        String score = tennisGame.getScore();
        assertEquals("Deuce",score);
    }

    @Test
    public void testPlayerOneAdvantageAfterDeuce_ShouldBeAdvantagePlayerOne(){
        tennisGame = new TennisGame();

        tennisGame.playerOneScores();
        tennisGame.playerOneScores();
        tennisGame.playerOneScores();

        tennisGame.playerTwoScores();
        tennisGame.playerTwoScores();
        tennisGame.playerTwoScores();

        tennisGame.playerOneScores();

        String score = tennisGame.getScore();
        assertEquals("Advantage Player 1",score);
    }

    @Test
    public void testPlayerTwoAdvantageAfterDeuce_ShouldBeAdvantagePlayerTwo(){
        tennisGame = new TennisGame();

        tennisGame.playerOneScores();
        tennisGame.playerOneScores();
        tennisGame.playerOneScores();

        tennisGame.playerTwoScores();
        tennisGame.playerTwoScores();
        tennisGame.playerTwoScores();
        tennisGame.playerTwoScores();

        String score = tennisGame.getScore();
        assertEquals("Advantage Player 2",score);
    }

    @Test
    public void testPlayerOneWinsAfterAdvantage_ShouldBeWinPlayerOne(){
        tennisGame = new TennisGame();

        tennisGame.playerTwoScores();
        tennisGame.playerTwoScores();
        tennisGame.playerTwoScores();

        tennisGame.playerOneScores();
        tennisGame.playerOneScores();
        tennisGame.playerOneScores();
        tennisGame.playerOneScores();
        tennisGame.playerOneScores();

        String score = tennisGame.getScore();
        assertEquals("Player 1 Wins",score);
    }

    @Test
    public void testPlayerTwoWinsAfterAdvantage_ShouldBeWinPlayerTwo(){
        tennisGame = new TennisGame();

        tennisGame.playerOneScores();
        tennisGame.playerOneScores();
        tennisGame.playerOneScores();

        tennisGame.playerTwoScores();
        tennisGame.playerTwoScores();
        tennisGame.playerTwoScores();
        tennisGame.playerTwoScores();
        tennisGame.playerTwoScores();

        String score = tennisGame.getScore();
        assertEquals("Player 2 Wins",score);
    }

    @Test
    public void testAdvantageLost_BackToDeuce(){
        tennisGame = new TennisGame();

        tennisGame.playerOneScores();
        tennisGame.playerOneScores();
        tennisGame.playerOneScores();

        tennisGame.playerTwoScores();
        tennisGame.playerTwoScores();
        tennisGame.playerTwoScores();

        tennisGame.playerOneScores();

        tennisGame.playerTwoScores();

        String score = tennisGame.getScore();
        assertEquals("Deuce",score);
    }

    // Winning the game

    @Test
    public void testPlayerOneWinsByTwoPoints_ShouldBeWinPlayerOne(){
        tennisGame = new TennisGame();

        tennisGame.playerTwoScores();
        tennisGame.playerTwoScores();

        tennisGame.playerOneScores();
        tennisGame.playerOneScores();
        tennisGame.playerOneScores();
        tennisGame.playerOneScores();

        String score = tennisGame.getScore();
        assertEquals("Player 1 Wins",score);
    }

    @Test
    public void testPlayerTwoWinsByTwoPoints_ShouldBeWinPlayerTwo(){
        tennisGame = new TennisGame();

        tennisGame.playerOneScores();
        tennisGame.playerOneScores();

        tennisGame.playerTwoScores();
        tennisGame.playerTwoScores();
        tennisGame.playerTwoScores();
        tennisGame.playerTwoScores();

        String score = tennisGame.getScore();
        assertEquals("Player 2 Wins",score);
    }


}
