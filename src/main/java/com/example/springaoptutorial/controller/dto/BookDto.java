package com.example.springaoptutorial.controller.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class BookDto {

    private UUID id;
    private String title;
    private String description;
}
