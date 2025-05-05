package com.furia.fanchat.controller;

import com.furia.fanchat.model.MatchMessage;
import com.furia.fanchat.repository.MatchMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.*;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/match-messages")
public class MatchMessageController {

    @Autowired
    private MatchMessageRepository repository;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    // REST - Carregar histórico
    @GetMapping("/{matchId}")
    public List<MatchMessage> getMessages(@PathVariable String matchId) {
        return repository.findByMatchIdOrderByTimestampAsc(matchId);
    }

    // WebSocket - Receber mensagem
    @MessageMapping("/match/{matchId}")
    public void handleMessage(@DestinationVariable String matchId, MatchMessage message) {
        message.setMatchId(matchId);
        message.setTimestamp(LocalDateTime.now());

        // Salva no banco
        repository.save(message);

        // Envia para todos que estão conectados
        messagingTemplate.convertAndSend("/topic/match/" + matchId, message);
    }
}
