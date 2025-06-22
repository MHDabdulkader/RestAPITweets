package com.example.RestAPITweets.repo;

import com.example.RestAPITweets.model.Users;
import com.example.RestAPITweets.projection.UserBasicView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UsersRepo extends JpaRepository<Users, UUID> {

}
