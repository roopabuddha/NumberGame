package com.numbergame.model;

public class GameRoom {
    private String roomId;
    private Player player1;
    private Player player2;
    private String currentTurnPlayerId;
    private boolean gameOver;
    private String winnerPlayerId;

    public GameRoom(String roomId) {
        this.roomId = roomId;
    }

    public String getRoomId() { return roomId; }

    public Player getPlayer1() { return player1; }
    public void setPlayer1(Player player1) { this.player1 = player1; }

    public Player getPlayer2() { return player2; }
    public void setPlayer2(Player player2) { this.player2 = player2; }

    public String getCurrentTurnPlayerId() { return currentTurnPlayerId; }
    public void setCurrentTurnPlayerId(String currentTurnPlayerId) { this.currentTurnPlayerId = currentTurnPlayerId; }

    public boolean isGameOver() { return gameOver; }
    public void setGameOver(boolean gameOver) { this.gameOver = gameOver; }

    public String getWinnerPlayerId() { return winnerPlayerId; }
    public void setWinnerPlayerId(String winnerPlayerId) { this.winnerPlayerId = winnerPlayerId; }
}
