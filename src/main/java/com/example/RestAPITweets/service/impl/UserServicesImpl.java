package com.example.RestAPITweets.service.impl;

import com.example.RestAPITweets.dto.user.UserRequestDTO;
import com.example.RestAPITweets.dto.user.UserResponseDTO;
import com.example.RestAPITweets.exceptions.ResourceNotFoundException;
import com.example.RestAPITweets.model.Users;
import com.example.RestAPITweets.repo.UsersRepo;
import com.example.RestAPITweets.service.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UserServicesImpl implements UserServices {
    private final UsersRepo usersRepo;


    @Override
    public ResponseEntity<UserResponseDTO> create(UserRequestDTO dto) {
        Users users = UserRequestDTO.toEntity(dto);
        Users saved = usersRepo.save(users);
        return ResponseEntity.status(HttpStatus.CREATED).body(UserResponseDTO.from(saved));
    }

    @Override
    public ResponseEntity<UserResponseDTO> get(UUID user_id) {
        Users users = usersRepo.findById(user_id).orElseThrow(()-> new ResourceNotFoundException("User not founded"+ user_id));
        return ResponseEntity.status(HttpStatus.OK).body(UserResponseDTO.from(users));
    }

    @Override
    public ResponseEntity<UserResponseDTO> update(UUID user_id, UserRequestDTO updateDto) {
        Users users = usersRepo.findById(user_id).orElseThrow(()-> new ResourceNotFoundException("User not founded"+ user_id));

        users.setEmail(updateDto.getEmail() == null ? users.getEmail(): updateDto.getEmail());
        users.setBio(updateDto.getBio() == null? users.getBio() : updateDto.getBio());
        users.setPassword(updateDto.getPassword() == null ? users.getPassword() : updateDto.getPassword());
        users.setUsername(updateDto.getUsername() == null ? users.getUsername() : updateDto.getUsername());

        Users saved = usersRepo.save(users);
        return ResponseEntity.status(HttpStatus.OK).body(UserResponseDTO.from(saved));
    }



    @Override
    public ResponseEntity<?> deleted(UUID user_id) {
        Users users = usersRepo.findById(user_id).orElseThrow(()->new ResourceNotFoundException("User did not founded, "+user_id));
        usersRepo.delete(users);
        return ResponseEntity.status(HttpStatus.OK).body("Deletion done! "+users.getUsername()+ " bye bye");
    }

    @Override
    public ResponseEntity<Users> dropped(UUID user_id) {
        return null;
    }
}
