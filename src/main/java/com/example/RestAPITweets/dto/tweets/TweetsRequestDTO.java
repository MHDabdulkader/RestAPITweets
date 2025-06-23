package com.example.RestAPITweets.dto.tweets;

import com.example.RestAPITweets.dto.media.MediaRequestDTO;
import com.example.RestAPITweets.model.Tweets;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Builder

public class TweetsRequestDTO {
    private String contend;
    private String username;
    private List<MediaRequestDTO> media;


}
