package com.furia.fanchat.model;

import lombok.Data;

@Data
public class User {
    private String id;
    private String username;
    private String avatar;
    private boolean isAdmin;
}