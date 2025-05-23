package com.furia.fanchat.repository;

import com.furia.fanchat.model.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, String> {
    List<ChatMessage> findTop50ByOrderByTimestampDesc();
}