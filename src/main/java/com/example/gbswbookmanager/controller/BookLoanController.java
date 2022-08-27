package com.example.gbswbookmanager.controller;

import com.example.gbswbookmanager.dto.BookLoanDetailDto;
import com.example.gbswbookmanager.dto.BookLoanDto;
import com.example.gbswbookmanager.dto.BookReturnDetialDto;
import com.example.gbswbookmanager.service.book.BookService;
import com.example.gbswbookmanager.service.bookLoan.BookLoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book/loan")
@RequiredArgsConstructor
public class BookLoanController {

    private final BookService bookService;

    private final BookLoanService bookLoanService;

    @GetMapping
    public ResponseEntity<List<BookLoanDetailDto>> getBookLoanList() {
        return ResponseEntity.ok().body(bookLoanService.getBookLoanList());
    }

    @PostMapping
    public ResponseEntity<?> bookLoan(@RequestBody BookLoanDto BookLoanDto) {
        if (bookLoanService.checkBookLoan(BookLoanDto)) {
            bookLoanService.bookLoan(BookLoanDto);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.ok().body("대출 신청을 한 책, 이미 대출 한 책 또는 수량이 부족합니다.");
    }

    @PostMapping("/approval")
    public ResponseEntity<?> loanApproval(@RequestParam Long id) throws Exception {
        if (bookService.checkBookQuantity(id)) {
            bookLoanService.loanApproval(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.ok().body("남은 책이 없습니다.");
        }
    }

    @DeleteMapping("/refuse")
    public void refuseBookLoan(@RequestParam Long id) {
        bookLoanService.refuseBookLoan(id);
    }

}
