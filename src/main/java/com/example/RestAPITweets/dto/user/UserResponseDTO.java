package com.example.RestAPITweets.dto.user;

import com.example.RestAPITweets.model.Users;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder

public class UserResponseDTO {
    private UUID id; // reveal user id dev purpose: TODO - remove userID on production;
    private String username;
    private String email;
    private String bio;

    public static UserResponseDTO from(Users users){
        return UserResponseDTO.builder()
                .id(users.getId()) // TODO - removed it;
                .username(users.getUsername())
                .email(users.getEmail())
                .bio(users.getBio())
                .build();
    }
}
