package com.furia.fanchat.controller;

import com.furia.fanchat.dto.ChatMessageDTO;
import com.furia.fanchat.model.ChatMessage;
import com.furia.fanchat.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "https://furiafanchat.netlify.app")
public class ChatController {

    private final ChatService chatService;

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public ChatMessageDTO handleMessage(ChatMessageDTO messageDTO) {
        if (messageDTO.getId() == null) {
            messageDTO.setId(UUID.randomUUID().toString());
        }
        ChatMessage entity = new ChatMessage();
        entity.setId(messageDTO.getId());
        entity.setContent(messageDTO.getContent());
        entity.setSenderId(messageDTO.getSender().getId());
        entity.setSenderUsername(messageDTO.getSender().getUsername());
        entity.setSenderAvatar(messageDTO.getSender().getAvatar());
        entity.setAdmin(messageDTO.isAdmin());
        entity.setTimestamp(LocalDateTime.now());

        chatService.saveAndBroadcast(entity);
        // Preencher senderId, senderUsername e senderAvatar se vierem nulos
        if (messageDTO.getId() == null && messageDTO.getSender().getUsername() == null) {
            messageDTO.getSender().setId("anonymous");
            messageDTO.getSender().setUsername("Anônimo");
            messageDTO.getSender().setAvatar("https://i.pravatar.cc/150?u=unknown");
        }

        chatService.saveAndBroadcast(entity);
        return messageDTO;
    }


    @GetMapping("/api/messages")
    public List<ChatMessage> getRecentMessages() {
        return chatService.getRecentMessages();
    }
}