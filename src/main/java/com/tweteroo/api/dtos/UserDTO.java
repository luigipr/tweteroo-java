package com.tweteroo.api.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDTO {
    
    @NotBlank(message = "Title is mandatory")
    @Size(max = 100)
    private String username;

    @NotBlank
    private String avatar;

}
