package com.example.RestAPITweets.repo;


import com.example.RestAPITweets.model.Subscriptions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository

public interface SubscriptionRepo extends JpaRepository<Subscriptions, UUID> {
}
