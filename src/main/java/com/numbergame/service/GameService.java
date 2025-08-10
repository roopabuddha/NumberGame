package com.numbergame.service;

import com.numbergame.model.*;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

@Service
public class GameService {

    private final Map<String, GameRoom> rooms = new ConcurrentHashMap<>();

    public GameRoom getOrCreateRoom(String roomId) {
        return rooms.computeIfAbsent(roomId, GameRoom::new);
    }

    public Player findPlayer(GameRoom room, String playerId) {
        if (room.getPlayer1() != null && room.getPlayer1().getId().equals(playerId)) return room.getPlayer1();
        if (room.getPlayer2() != null && room.getPlayer2().getId().equals(playerId)) return room.getPlayer2();
        return null;
    }

    public void addPlayerToRoom(GameRoom room, Player player) {
        if (room.getPlayer1() == null) {
            room.setPlayer1(player);
        } else if (room.getPlayer2() == null) {
            room.setPlayer2(player);
        }
    }

    public Player getOpponent(GameRoom room, String playerId) {
        if (room.getPlayer1() != null && !room.getPlayer1().getId().equals(playerId))
            return room.getPlayer1();
        if (room.getPlayer2() != null && !room.getPlayer2().getId().equals(playerId))
            return room.getPlayer2();
        return null;
    }

    public String calculateFeedback(String secret, String guess) {
        if (secret.equals(guess)) {
            return "Exact Match";
        }

        StringBuilder sb = new StringBuilder();
        if (secret.charAt(0) == guess.charAt(0)) sb.append("Thousands place, ");
        if (secret.charAt(1) == guess.charAt(1)) sb.append("Hundreds place, ");
        if (secret.charAt(2) == guess.charAt(2)) sb.append("Tens place, ");
        if (secret.charAt(3) == guess.charAt(3)) sb.append("Ones place, ");

        if (sb.length() == 0) return "No match";

        // Remove last comma and space
        return sb.substring(0, sb.length() - 2) + " matches";
    }
}
