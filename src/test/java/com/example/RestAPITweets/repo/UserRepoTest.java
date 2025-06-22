package com.example.RestAPITweets.repo;

import com.example.RestAPITweets.model.Users;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@DataJpaTest
@DisplayName("saved user and print result")

class UserRepoTest {
    @Autowired
    private UsersRepo usersRepo;



    @Test
    void testSaveUser(){
        Users users = Users.builder()
                .username("user1")
                .email("user1@gmail.com")
                .password("1234")
                .bio("Test1 bio")
                .build();
        Users saved = usersRepo.save(users);
        System.out.println("🔍 saved user: "+ saved);
        assertNotNull(saved.getId());
    }

    @Test
    void testFindUserById(){
        Users users = Users.builder()
                .username("user2")
                .email("user2@gmail.com")
                .password("1234")
                .bio("Test2 bio")
                .build();

        Users saved = usersRepo.save(users);

        Optional<Users> find = usersRepo.findById(saved.getId());
        System.out.println("👌 find user: "+find);
        assertTrue(find.isPresent());
        assertEquals("user2", find.get().getUsername());
    }
}
