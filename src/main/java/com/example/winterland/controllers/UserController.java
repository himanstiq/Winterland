package com.example.winterland.controllers;

import com.example.winterland.entities.UserEntity;
import com.example.winterland.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // POST /user
    @PostMapping
    public UserEntity createUser(@RequestBody UserEntity userEntity) {
        return userService.createUser(userEntity);
    }

    // GET /user
    @GetMapping
    public List<UserEntity> findAll() {
        return userService.findAll();
    }

    // GET /user/search?email=abc@gmail.com
    @GetMapping("/search")
    public List<UserEntity> findAllByEmail(@RequestParam String email) {
        return userService.findAllByEmail(email);
    }
}
