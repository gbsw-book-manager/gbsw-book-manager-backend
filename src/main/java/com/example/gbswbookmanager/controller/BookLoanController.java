package com.example.gbswbookmanager.controller;

import com.example.gbswbookmanager.dto.LoanDetailDto;
import com.example.gbswbookmanager.dto.LoanDto;
import com.example.gbswbookmanager.service.book.BookLoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book/loan")
@RequiredArgsConstructor
public class BookLoanController {

    private final BookLoanService bookLoanService;

    @GetMapping
    public ResponseEntity<List<LoanDetailDto>> getBookLoanList() {
        return ResponseEntity.ok().body(bookLoanService.getBookLoanList());
    }

    @PostMapping
    public ResponseEntity<?> bookLoan(@RequestBody LoanDto loanDto) {
        if (bookLoanService.checkBookLoan(loanDto)) {
            bookLoanService.bookLoan(loanDto);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.ok().body("이미 빌린 책이 포함되어 있습니다.");
    }

}
