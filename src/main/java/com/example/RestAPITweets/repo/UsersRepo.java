package com.example.RestAPITweets.repo;

import com.example.RestAPITweets.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UsersRepo extends JpaRepository<Users, UUID> {
    Users findByUsernameIgnoreCase(@Param("username") String username);
}
