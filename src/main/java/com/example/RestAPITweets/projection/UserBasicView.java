package com.example.RestAPITweets.projection;

import java.util.UUID;

// read - only views for user basic view (except relations)
public interface UserBasicView {
    UUID getId();
    String getUserName();
    String getEmail();
    String getBio();
}
