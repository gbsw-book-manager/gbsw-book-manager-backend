package com.example.gbswbookmanager.controller;

import com.example.gbswbookmanager.dto.BookDto;
import com.example.gbswbookmanager.dto.LoanDto;
import com.example.gbswbookmanager.dto.LoanResponseDto;
import com.example.gbswbookmanager.entity.Book;
import com.example.gbswbookmanager.entity.BookLoan;
import com.example.gbswbookmanager.service.book.BookService;
import com.example.gbswbookmanager.service.user.UserService;
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

    private final UserService userService;

    @GetMapping
    public ResponseEntity<?> getBookOrBooks(@RequestParam(required = false) Long id) {
        if (id != null) {
            return ResponseEntity.ok().body(bookService.getBook(id));
        } else {
            return ResponseEntity.ok().body(bookService.getBooks());
        }
    }

    @GetMapping("/loan")
    public ResponseEntity<List<LoanResponseDto>> getBookLoan() {
        return ResponseEntity.ok().body(bookService.getBookLoan());
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

    @PostMapping("/loan")
    public void bookLoan(@RequestBody LoanDto loanDto) {
        bookService.bookLoan(loanDto);
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
            return ResponseEntity.ok().body(userService.getUserNameByBookId(id));
        }
    }

}