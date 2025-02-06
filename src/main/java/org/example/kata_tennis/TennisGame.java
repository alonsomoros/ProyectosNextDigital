package org.example.kata_tennis;

import java.util.Map;

public class TennisGame {

    Map<Integer, String> scoring = Map.of(0, "Love", 1, "Fifteen", 2, "Thirty",3,"Fourty");


    private int scorePlayer1;
    private int scorePlayer2;

    public TennisGame() {
        this.scorePlayer1 = 0;
        this.scorePlayer2 = 0;
    }

    public String getScore() {
        String score = "";
        if (scorePlayer1 == scorePlayer2) {
            score = checkSameResult();
        } else {
            score = checkDifferentResult();
        }
        return score;
    }

    private String checkDifferentResult() {
        String score = "";
        if (scorePlayer1 > 3 || scorePlayer2 > 3) {
            if (scorePlayer1 - scorePlayer2 == 1) {
                score = "Advantage Player 1";
            } else if (scorePlayer2 - scorePlayer1 == 1) { // Tanto si es 4-1 como 4-2 no sería ventaja sería win
                score = "Advantage Player 2";
            } else if (scorePlayer1 - scorePlayer2 >= 2) {
                score = "Player 1 Wins";
            } else {
                score = "Player 2 Wins";
            }
        } else {
            score = scoring.get(scorePlayer1) + "-" + scoring.get(scorePlayer2);
        }
        return score;
    }

    private String checkSameResult() {
        String score = "";
        if (scorePlayer1 == 0){
            score = "Love-Love";
        } else if (scorePlayer1 == 3) {
            score = "Deuce";
        } else {
            score = scoring.get(scorePlayer1) + "-All";
        }
        return score;
    }

    public void playerOneScores(){
        if (scorePlayer2 == 4){
            this.scorePlayer2--;
        } else this.scorePlayer1++;
    }

    public void playerTwoScores(){
        if(scorePlayer1 == 4){
            this.scorePlayer1--;
        } else this.scorePlayer2++;
    }
}
