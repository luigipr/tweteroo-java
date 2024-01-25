package com.tweteroo.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dtos.UserDTO;
import com.tweteroo.api.models.UserModel;
import com.tweteroo.api.services.UserService;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/users")
public class UserController {
    
    final UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping    
    public ResponseEntity<List<UserModel>> getUsers() {
        List<UserModel> users = userService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @PostMapping
    public ResponseEntity<Object> createUser(@RequestBody @Valid UserDTO body) {
        Optional<UserModel> user = userService.save(body);

        if (!user.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("A user with this name already exists");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}
