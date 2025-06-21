package com.example.RestAPITweets.repo;

import com.example.RestAPITweets.model.Tweets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TweetsRepo extends JpaRepository<Tweets, UUID> {
}
