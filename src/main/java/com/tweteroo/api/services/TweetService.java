package com.tweteroo.api.services;

import org.springframework.stereotype.Service;

import com.tweteroo.api.repositories.UserRepository;


@Service
public class TweetService {
      
    final UserRepository userRepository;

    
    TweetService(TweetRepository userRepository) {
        this.userRepository = userRepository;
    }
}
