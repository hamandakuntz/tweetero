package com.tweteroo.api.dtos;

import jakarta.validation.constraints.NotEmpty;

public record TweetDTO( 
    @NotEmpty
    String text){
}
