package com.example.RestAPITweets.repo;

import com.example.RestAPITweets.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository

public interface SubscriptionRepo extends JpaRepository<Subscription, UUID> {
}
