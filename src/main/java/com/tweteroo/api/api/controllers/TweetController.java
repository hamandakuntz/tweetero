package com.tweteroo.api.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.api.models.Tweet;
import com.tweteroo.api.api.services.TweetService;
import com.tweteroo.api.dtos.TweetDTO;

import jakarta.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/tweets")
public class TweetController {
    @Autowired
    private TweetService tweetService;

    @GetMapping
    public Page<Tweet> getTweetsList(@RequestParam(value = "page", defaultValue = "0") int page) {
        return tweetService.getTweetsList(page, 5);
    }

    @GetMapping("/{username}")
    public ResponseEntity<List<Tweet>> getTweetsByUsername(@PathVariable(value = "username") String username) {
        List<Tweet> tweet = tweetService.getTweetsOfUser(username);

        if (!tweet.isEmpty()) {
            return ResponseEntity.ok().body(tweet);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody @Valid TweetDTO tweet,
            @RequestHeader("User") String username) {
        tweetService.createTweet(tweet, username);
        return ResponseEntity.status(HttpStatus.CREATED).body("OK");
    }
}
