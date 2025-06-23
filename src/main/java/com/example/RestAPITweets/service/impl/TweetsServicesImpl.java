package com.example.RestAPITweets.service.impl;

import com.example.RestAPITweets.dto.media.MediaResponseDTO;
import com.example.RestAPITweets.dto.tweets.TweetsRequestDTO;
import com.example.RestAPITweets.dto.tweets.TweetsResponseDTO;
import com.example.RestAPITweets.model.Media;
import com.example.RestAPITweets.model.Tweets;
import com.example.RestAPITweets.model.Users;
import com.example.RestAPITweets.repo.MediaRepo;
import com.example.RestAPITweets.repo.TweetsRepo;
import com.example.RestAPITweets.repo.UsersRepo;
import com.example.RestAPITweets.service.TweetsServices;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TweetsServicesImpl implements TweetsServices {
    @Autowired
    private TweetsRepo tweetsRepo;
    @Autowired
    private MediaRepo mediaRepo;
    @Autowired
    private UsersRepo usersRepo;

    @Override
    public ResponseEntity<?> create(TweetsRequestDTO dto) {
        Users users = usersRepo.findByUsernameIgnoreCase(dto.getUsername());
        if(users == null){
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("Tweet create user is not authorized"+dto.getUsername());
        }
        // toEntity
        Tweets tweets = new Tweets();
        tweets.setContend(dto.getContend());
        tweets.setUsers(users);

        List<Media> mediaUsed = dto.getMedia().stream().map(mediaRequestDTO -> {
            return Media.builder()
                    .fileUrl(mediaRequestDTO.getFileUrl())
                    .type(mediaRequestDTO.getType())
                    .build();
        }).toList();

        tweets.setMedia(mediaUsed);

        // Save entity
        Tweets saved = tweetsRepo.save(tweets);

        // send response
        TweetsResponseDTO response =  TweetsResponseDTO.builder()
                .username(saved.getUsers().getUsername())
                .contend(saved.getContend())
                .tweet_id(saved.getId())
                .updateAt(saved.getUpdateAt())
                .media(saved.getMedia().stream()
                        .map(m-> MediaResponseDTO.builder()
                                .fileUrl(m.getFileUrl())
                                .type(m.getType())
                                .createAt(m.getCreateAt())
                                .build())
                        .toList())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Override
    public ResponseEntity<TweetsResponseDTO> update(UUID tweet_id, UUID user_id, TweetsRequestDTO updateDto) {
        return null;
    }

    @Override
    public ResponseEntity<TweetsResponseDTO> get(UUID tweet_id, UUID user_id) {
        return null;
    }

    @Override
    public ResponseEntity<List<TweetsResponseDTO>> all(UUID user_id) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleted(UUID tweet_id, UUID user_id) {
        return null;
    }

    @Override
    public ResponseEntity<List<TweetsResponseDTO>> searchByContend(String searchContend) {
        return null;
    }
}
