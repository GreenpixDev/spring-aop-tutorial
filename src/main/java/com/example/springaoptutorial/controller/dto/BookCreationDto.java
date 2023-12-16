package com.example.springaoptutorial.controller.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class BookDto {

    private UUID id;
    private String title;
    private String description;
}
