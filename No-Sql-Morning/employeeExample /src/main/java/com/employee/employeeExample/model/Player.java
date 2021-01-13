package com.employee.employeeExample.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

@Document
public class Player {
    @Id
    private String playerId;
    private String playerName;
    private float playerAverage;
    private int playerRuns;
    private int playerWicket;

    public Player(String playerId, String playerName, float playerAverage, int playerRuns, int playerWicket) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.playerAverage = playerAverage;
        this.playerRuns = playerRuns;
        this.playerWicket = playerWicket;
    }


    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public float getPlayerAverage() {
        return playerAverage;
    }

    public void setPlayerAverage(float playerAverage) {
        this.playerAverage = playerAverage;
    }

    public int getPlayerRuns() {
        return playerRuns;
    }

    public void setPlayerRuns(int playerRuns) {
        this.playerRuns = playerRuns;
    }

    public int getPlayerWicket() {
        return playerWicket;
    }

    public void setPlayerWicket(int playerWicket) {
        this.playerWicket = playerWicket;
    }

}
