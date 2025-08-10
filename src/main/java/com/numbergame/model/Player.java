package com.numbergame.model;

public class Player {
    private String id;
    private String secret;
    private boolean hasSetSecret;

    public Player(String id) {
        this.id = id;
    }

    public String getId() { return id; }
    public String getSecret() { return secret; }
    public void setSecret(String secret) {
        this.secret = secret;
        this.hasSetSecret = true;
    }
    public boolean isHasSetSecret() { return hasSetSecret; }
}
