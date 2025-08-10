package com.numbergame.model;

public class GuessMessage {
    private String roomId;
    private String playerId;
    private String guess;

    public String getRoomId() { return roomId; }
    public void setRoomId(String roomId) { this.roomId = roomId; }

    public String getPlayerId() { return playerId; }
    public void setPlayerId(String playerId) { this.playerId = playerId; }

    public String getGuess() { return guess; }
    public void setGuess(String guess) { this.guess = guess; }
}
