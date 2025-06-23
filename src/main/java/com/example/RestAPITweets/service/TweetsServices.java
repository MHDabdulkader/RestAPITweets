package com.example.RestAPITweets.service;

import com.example.RestAPITweets.dto.tweets.TweetsRequestDTO;
import com.example.RestAPITweets.dto.tweets.TweetsResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface TweetsServices {
    ResponseEntity<?> create(TweetsRequestDTO dto);
    ResponseEntity<TweetsResponseDTO> update(UUID tweet_id, UUID user_id, TweetsRequestDTO updateDto);
    ResponseEntity<TweetsResponseDTO> get(UUID tweet_id, UUID user_id);
    ResponseEntity<List<TweetsResponseDTO>> all(UUID user_id);
    ResponseEntity<?> deleted(UUID tweet_id, UUID user_id);
    ResponseEntity<List<TweetsResponseDTO>> searchByContend(String searchContend);


}
