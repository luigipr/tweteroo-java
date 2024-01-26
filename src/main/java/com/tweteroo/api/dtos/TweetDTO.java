package com.tweteroo.api.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TweetDTO {
    @NotBlank(message = "Text cannot be empty")
    @Size(max = 280)
    private String text;

    @NotBlank
    
}
