package com.example.gbswbookmanager.controller;

import com.example.gbswbookmanager.entity.book.BookApplication;
import com.example.gbswbookmanager.service.bookApplication.BookApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/book/application")
public class BookApplicationController {

    public final BookApplicationService bookApplicationService;

    @GetMapping
    public ResponseEntity<List<BookApplication>> getBookApplications() {
        return ResponseEntity.ok().body(bookApplicationService.getBookApplications());
    }

    @PostMapping
    public void addBookApplication(@RequestBody BookApplication bookApplication) {
        bookApplicationService.addBookApplication(bookApplication);
    }

}
