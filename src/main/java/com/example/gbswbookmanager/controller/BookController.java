package com.example.gbswbookmanager.controller;

import com.example.gbswbookmanager.dto.BookInfo;
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
    public void InsertOrUpdateBook(@RequestBody BookInfo bookInfo) {
        String bookTitle = bookInfo.getTitle();

        if (bookService.checkBookExistence(bookTitle)) {
            bookService.updateBookQuantity(bookInfo);
            log.info("book update is completed");
        } else {
            Book book = new Book(
                    null,
                    bookInfo.getTitle(),
                    bookInfo.getAuthor(),
                    bookInfo.getPublisher(),
                    bookInfo.getQuantity(),
                    bookInfo.getQuantity()
            );
            log.info("book insert is completed");

            bookService.saveBook(book);
        }
    }

}
