package com.example.springaoptutorial.repository;

import com.example.springaoptutorial.repository.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, UUID> {
}
