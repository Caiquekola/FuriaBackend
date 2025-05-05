package com.furia.fanchat.repository;

import com.furia.fanchat.model.MatchMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchMessageRepository extends JpaRepository<MatchMessage, String> {

    List<MatchMessage> findByMatchIdOrderByTimestampAsc(String matchId);
}

