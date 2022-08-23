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
    public ResponseEntity<?> getBookOrBooks(@RequestParam(required = false) Long id) {
        if (id != null) {
            return ResponseEntity.ok().body(bookService.getBook(id));
        } else {
            return ResponseEntity.ok().body(bookService.getBooks());
        }
    }

    @PostMapping
    public void InsertOrUpdateBook(@RequestBody BookDto bookDto) {
        if (bookService.checkBookExistence(bookDto.getTitle())) {
            bookService.updateBookQuantity(bookDto);
            log.info("book update is completed");
        } else {
            Book book = bookService.setBook(bookDto);
            log.info("book insert is completed");
            bookService.addBook(book);
        }
    }

    @PutMapping
    public void updateBook(@RequestBody Book book) {
        bookService.updateBook(book);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteBook(@RequestParam Long id) {
        try {
            bookService.deleteBook(id);
            log.info("정상적으로 삭제하였습니다.");
            return ResponseEntity.ok().build();
        } catch (Exception exception) {
            log.info("{} 책은 대출되어 있는 책입니다.", bookService.getBook(id).getTitle());
            return ResponseEntity.ok().body("대출되어 있는 책입니다.");
        }
    }

}