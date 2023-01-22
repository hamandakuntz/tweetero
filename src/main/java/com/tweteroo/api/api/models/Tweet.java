package com.tweteroo.api.api.models;

import com.tweteroo.api.dtos.TweetDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Tweet {
    
    public Tweet(TweetDTO data, String username, String avatar) {
        this.username = username;
        this.text = data.text();
        this.avatar = avatar;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 50, nullable = false)
    private String username;

    @Column(length = 200, nullable = false)
    private String avatar;

    @Column(length = 200, nullable = false)
    private String text;
}
