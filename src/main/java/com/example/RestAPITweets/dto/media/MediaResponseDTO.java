package com.example.RestAPITweets.dto.media;

import com.example.RestAPITweets.model.enums.MediaType;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class MediaResponseDTO {
    private String fileUrl;
    private MediaType type;
    private LocalDateTime createAt;
}
