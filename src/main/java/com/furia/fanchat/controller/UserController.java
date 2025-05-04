package com.furia.fanchat.controller;

import com.furia.fanchat.dto.UserDTO;
import com.furia.fanchat.model.User;
import com.furia.fanchat.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@CrossOrigin(origins = "https://furiafanchat.netlify.app")
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public User register(@RequestBody UserDTO userDTO) {
        return userService.registerUser(userDTO.getUsername(), userDTO.getAvatar());
    }

    @GetMapping("/users/{id}")
    public Optional<User> getUser(@PathVariable String id) {
        return userService.getUserById(id);
    }
}
