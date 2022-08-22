package com.example.gbswbookmanager.controller;

import com.example.gbswbookmanager.dto.BookDto;
import com.example.gbswbookmanager.entity.Book;
import com.example.gbswbookmanager.service.Book.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>> getBooks() {
        return ResponseEntity.ok().body(bookService.getBooks());
    }

    @PostMapping
    public void InsertOrUpdateBook(@RequestBody BookDto bookDto) {
        String bookTitle = bookDto.getTitle();

        if (bookService.checkBookExistence(bookTitle)) {
            bookService.updateBookQuantity(bookDto);
            log.info("book update is completed");
        } else {
            Book book = new Book(
                    null,
                    bookDto.getTitle(),
                    bookDto.getAuthor(),
                    bookDto.getPublisher(),
                    bookDto.getQuantity(),
                    bookDto.getQuantity()
            );
            log.info("book insert is completed");

            bookService.saveBook(book);
        }
    }

}
