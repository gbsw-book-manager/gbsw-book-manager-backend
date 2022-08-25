package com.example.gbswbookmanager.controller;

import com.example.gbswbookmanager.dto.LoanDetailDto;
import com.example.gbswbookmanager.dto.LoanDto;
import com.example.gbswbookmanager.service.book.BookService;
import com.example.gbswbookmanager.service.bookLoan.BookLoanService;
import com.example.gbswbookmanager.service.mail.LoanMailService;
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

    private final LoanMailService loanMailService;

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

    @PostMapping("/approval")
    public ResponseEntity<?> loanApproval(@RequestParam Long id) throws Exception {
        if (bookService.checkBookQuantity(id)) {
            bookLoanService.loanApproval(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.ok().body("남은 책이 없습니다.");
        }
    }

}
