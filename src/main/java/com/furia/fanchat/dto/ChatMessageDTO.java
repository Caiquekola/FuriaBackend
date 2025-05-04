package com.furia.fanchat.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ChatMessageDTO {

    private String id;
    private String content;

    private SenderDTO sender;

    private boolean isAdmin;
    private LocalDateTime timestamp;

    @Data
    public static class SenderDTO {
        private String id;
        private String username;
        private String avatar;
    }
}
