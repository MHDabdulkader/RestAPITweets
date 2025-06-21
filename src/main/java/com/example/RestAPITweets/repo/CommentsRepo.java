package com.example.RestAPITweets.repo;

import com.example.RestAPITweets.model.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CommentsRepo extends JpaRepository<Comments, UUID> {
}
