package com.example.springaoptutorial.service;

import com.example.springaoptutorial.annotation.Logging;
import com.example.springaoptutorial.controller.dto.BookCreationDto;
import com.example.springaoptutorial.controller.dto.BookDto;
import com.example.springaoptutorial.repository.BookRepository;
import com.example.springaoptutorial.repository.entity.Book;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final BookService bookService;

    @Logging
    public UUID createBook(BookCreationDto bookCreationDto) {

        bookService.getBook(UUID.randomUUID());

        return bookRepository.save(Book.builder()
                .title(bookCreationDto.getTitle())
                .description(bookCreationDto.getDescription())
                .build()
        ).getId();
    }

    @Logging
    public BookDto getBook(UUID id) {
        Book book = bookRepository.findById(id).orElseThrow();
        return BookDto.builder()
                .id(book.getId())
                .title(book.getTitle())
                .description(book.getDescription())
                .build();
    }

    public void deleteBook(UUID id) {
        bookRepository.deleteById(id);
    }
}
