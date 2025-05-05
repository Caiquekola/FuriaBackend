package com.furia.fanchat.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "match_messages")
public class MatchMessage {

    @Id
    private String id;

    private String matchId;
    private String content;
    private String senderId;
    private String senderUsername;
    private String senderAvatar;
    private boolean isAdmin;

    private LocalDateTime timestamp;

}

