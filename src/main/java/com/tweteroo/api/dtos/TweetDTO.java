package com.tweteroo.api.dtos;

import jakarta.validation.constraints.NotBlank;

public record TweetDTO( 
    @NotBlank
    String text){
}
