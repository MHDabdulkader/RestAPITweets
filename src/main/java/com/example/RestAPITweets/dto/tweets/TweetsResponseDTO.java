package com.example.RestAPITweets.dto.tweets;

import com.example.RestAPITweets.dto.media.MediaResponseDTO;
import com.example.RestAPITweets.model.Media;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Builder

public class TweetsResponseDTO {
    private String username; // find username using user_id
    private UUID tweet_id;
    private String contend;
    private LocalDateTime updateAt;
    private List<MediaResponseDTO> media;
}
