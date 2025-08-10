package com.numbergame.model;

public class SetSecretMessage {
    private String roomId;
    private String playerId;
    private String secret;

    public String getRoomId() { return roomId; }
    public void setRoomId(String roomId) { this.roomId = roomId; }

    public String getPlayerId() { return playerId; }
    public void setPlayerId(String playerId) { this.playerId = playerId; }

    public String getSecret() { return secret; }
    public void setSecret(String secret) { this.secret = secret; }
}
