package com.example.RestAPITweets.service;

import com.example.RestAPITweets.dto.user.UserRequestDTO;
import com.example.RestAPITweets.dto.user.UserResponseDTO;
import com.example.RestAPITweets.model.Users;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public interface UserServices {
    // response entity UserResponseDto, UserRequestDto;

    ResponseEntity<UserResponseDTO> create(UserRequestDTO dto);
    ResponseEntity<UserResponseDTO> get(UUID user_id);
    ResponseEntity<UserResponseDTO> update(UUID user_id, UserRequestDTO updateDto);
    //ResponseEntity<UserResponseDTO> patch(UUID user_id, Objects updateMap);
    ResponseEntity<?> deleted(UUID user_id); // TODO - deleted information store a backups
    ResponseEntity<Users> dropped(UUID user_id);
}
