package com.example.RestAPITweets.controller;

import com.example.RestAPITweets.dto.user.UserRequestDTO;
import com.example.RestAPITweets.service.UserServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/user")
@Tag(name = "User", description = "User management APIs")
public class UserController {
    @Autowired
    private UserServices services;

    @PostMapping("/create")
    @Operation(summary = "Create a new user ", description = "Register new user for the system")
    public ResponseEntity<?> createUser(@RequestBody UserRequestDTO dto){
        return services.create(dto);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get user by ID")
    public ResponseEntity<?> getAUser(@PathVariable UUID id){
        return services.get(id);
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "Update whole information about a user")
    public ResponseEntity<?> updateUser(@PathVariable UUID id, @RequestBody UserRequestDTO dto){
        return services.update(id, dto);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete user ")
    public ResponseEntity<?> deleteUser(@PathVariable UUID id){
        return services.deleted(id);
    }

}
