package com.example.RestAPITweets.dto.media;

import com.example.RestAPITweets.model.enums.MediaType;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class MediaRequestDTO {
    private String fileUrl;
    private MediaType type;


}
