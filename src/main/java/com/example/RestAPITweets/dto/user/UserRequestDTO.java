package com.example.RestAPITweets.dto.user;

import com.example.RestAPITweets.model.Users;
import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class UserRequestDTO {
    private String username;
    private String email;
    private String password;
    private String bio;

    // dto to entity;
    public static Users toEntity(UserRequestDTO dto){
        return Users.builder()
                .username(dto.getUsername())
                .email(dto.getEmail())
                .bio(dto.getBio())
                .build();
    }
}
