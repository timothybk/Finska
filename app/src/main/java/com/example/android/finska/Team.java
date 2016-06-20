package com.example.android.finska;

/**
 * Created by timbk on 1/06/2016.
 */
public class Team {
    private String playerOne;
    private String playerTwo;
    private int teamNumber = 0;
    private int score = 0;

    //public Team(String playerOne, String playerTwo, int teamNumber, int score){}

    public void setPlayers(String playerOne, String playerTwo)
    {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public String getPlayerOne()
    {
        return playerOne;
    }

    public String getPlayerTwo() {
        return playerTwo;
    }

    public void setTeamNumber(int teamNumber) {
        this.teamNumber = teamNumber;
    }

    public int getTeamNumber() {
        return teamNumber;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public String makeString(){
        String team = "TEAM " + String.valueOf(teamNumber) +
                "\n" + playerOne +
                "\n" + playerTwo; //+ String.valueOf(score);
        return team;
    }
}
