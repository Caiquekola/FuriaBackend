package com.furia.fanchat.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    private String id;
    private String username;
    private String avatar;
    private boolean isAdmin;
}