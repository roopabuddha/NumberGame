package com.numbergame.model;

public class GameState {
    private String roomId;
    private String currentTurnPlayerId;
    private boolean gameOver;
    private String winnerPlayerId;
    private String lastFeedback;
    private String lastGuessPlayerId;

    // Getters and setters omitted for brevity

    public String getRoomId() { return roomId; }
    public void setRoomId(String roomId) { this.roomId = roomId; }

    public String getCurrentTurnPlayerId() { return currentTurnPlayerId; }
    public void setCurrentTurnPlayerId(String currentTurnPlayerId) { this.currentTurnPlayerId = currentTurnPlayerId; }

    public boolean isGameOver() { return gameOver; }
    public void setGameOver(boolean gameOver) { this.gameOver = gameOver; }

    public String getWinnerPlayerId() { return winnerPlayerId; }
    public void setWinnerPlayerId(String winnerPlayerId) { this.winnerPlayerId = winnerPlayerId; }

    public String getLastFeedback() { return lastFeedback; }
    public void setLastFeedback(String lastFeedback) { this.lastFeedback = lastFeedback; }

    public String getLastGuessPlayerId() { return lastGuessPlayerId; }
    public void setLastGuessPlayerId(String lastGuessPlayerId) { this.lastGuessPlayerId = lastGuessPlayerId; }
}
