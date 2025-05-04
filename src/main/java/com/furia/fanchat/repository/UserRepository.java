package com.furia.fanchat.repository;

import com.furia.fanchat.model.GameStatus;
import com.furia.fanchat.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
