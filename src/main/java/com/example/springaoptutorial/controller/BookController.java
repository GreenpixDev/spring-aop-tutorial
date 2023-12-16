package com.example.springaoptutorial.controller;

import com.example.springaoptutorial.annotation.Logging;
import com.example.springaoptutorial.controller.dto.BookCreationDto;
import com.example.springaoptutorial.controller.dto.BookDto;
import com.example.springaoptutorial.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping
    public UUID createBook(@RequestBody BookCreationDto dto) {
        return bookService.createBook(dto);
    }

    @GetMapping("{id}")
    public BookDto getBook(@PathVariable("id") UUID id) {
        return bookService.getBook(id);
    }

    @DeleteMapping("{id}")
    public void deleteBook(@PathVariable("id") UUID id) {
        bookService.deleteBook(id);
    }
}
