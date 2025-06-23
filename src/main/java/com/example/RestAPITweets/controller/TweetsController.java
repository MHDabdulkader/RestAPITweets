package com.example.RestAPITweets.controller;

import com.example.RestAPITweets.dto.tweets.TweetsRequestDTO;
import com.example.RestAPITweets.service.TweetsServices;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tweets")
@Tag(name = "Tweets", description = "Tweets create by user and also add some media too")
public class TweetsController {
    @Autowired
    private TweetsServices services;

    @PostMapping("/create")
    public ResponseEntity<?> createANewTweets(@RequestBody TweetsRequestDTO dto){
        return services.create(dto);
    }
}
