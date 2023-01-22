package com.tweteroo.api.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.tweteroo.api.api.models.Tweet;
import com.tweteroo.api.api.models.Person;
import com.tweteroo.api.api.repositories.TweetRepository;
import com.tweteroo.api.api.repositories.PersonRepository;
import com.tweteroo.api.dtos.TweetDTO;

@Service
public class TweetService {
    @Autowired
    TweetRepository tweetRepository;

    @Autowired
    PersonRepository userRepository;

    public void createTweet(TweetDTO tweet, String username) {
        List<Person> user = userRepository.findByUsername(username);
        if (user.isEmpty())
            return;

        String avatar = user.get(0).getAvatar();
        tweetRepository.save(new Tweet(tweet, username, avatar));
    }

    public Page<Tweet> getTweetsList(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("id").descending());
        return tweetRepository.findAll(pageable);
    }

    public List<Tweet> getTweetsOfUser(String username) {
        return tweetRepository.findByUsername(username);
    }

}
