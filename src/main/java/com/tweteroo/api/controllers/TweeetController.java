package com.tweteroo.api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.models.TweetModel;
import com.tweteroo.api.services.TweetService;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tweets")
public class TweeetController {
    
    final TweetService tweetService;

    TweetController(TweetService tweetService) {
        this.tweetService = tweetService;
    }

    @GetMapping    
    public ResponseEntity<List<TweetModel>> getTweets() {
        List<TweetModel> tweets = tweetservice.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(tweets);
    }

}
