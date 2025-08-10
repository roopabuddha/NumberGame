package com.numbergame.controller;

import com.numbergame.model.*;
import com.numbergame.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class GameController {

    @Autowired
    private GameService gameService;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/setSecret")
    public void setSecret(SetSecretMessage message) {
        GameRoom room = gameService.getOrCreateRoom(message.getRoomId());

        Player player = gameService.findPlayer(room, message.getPlayerId());
        if (player == null) {
            player = new Player(message.getPlayerId());
            gameService.addPlayerToRoom(room, player);
        }

        player.setSecret(message.getSecret());

        // Start game if both players ready
        if (room.getPlayer1() != null && room.getPlayer2() != null &&
            room.getPlayer1().isHasSetSecret() && room.getPlayer2().isHasSetSecret() &&
            room.getCurrentTurnPlayerId() == null) {
            room.setCurrentTurnPlayerId(room.getPlayer1().getId());
        }

        broadcastGameState(room, null, null);
    }

    @MessageMapping("/guess")
    public void guess(GuessMessage message) {
        GameRoom room = gameService.getOrCreateRoom(message.getRoomId());
        if (room.isGameOver()) return;

        if (!message.getPlayerId().equals(room.getCurrentTurnPlayerId())) {
            // Not this player's turn
            return;
        }

        Player opponent = gameService.getOpponent(room, message.getPlayerId());
        if (opponent == null || !opponent.isHasSetSecret()) return;

        String feedback = gameService.calculateFeedback(opponent.getSecret(), message.getGuess());

        if ("Exact Match".equals(feedback)) {
            room.setGameOver(true);
            room.setWinnerPlayerId(message.getPlayerId());
        } else {
            // Switch turn to opponent
            room.setCurrentTurnPlayerId(opponent.getId());
        }

        broadcastGameState(room, feedback, message.getPlayerId());
    }

    private void broadcastGameState(GameRoom room, String lastFeedback, String lastPlayerId) {
        GameState state = new GameState();
        state.setRoomId(room.getRoomId());
        state.setCurrentTurnPlayerId(room.getCurrentTurnPlayerId());
        state.setGameOver(room.isGameOver());
        state.setWinnerPlayerId(room.getWinnerPlayerId());
        state.setLastFeedback(lastFeedback);
        state.setLastGuessPlayerId(lastPlayerId);

        messagingTemplate.convertAndSend("/topic/game-room." + room.getRoomId(), state);
    }
}
