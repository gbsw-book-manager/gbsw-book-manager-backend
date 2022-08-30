package com.example.gbswbookmanager.controller;

import com.example.gbswbookmanager.entity.BookOverdue;
import com.example.gbswbookmanager.service.bookOverdue.BookOverdueService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/book/overdue")
public class BookOverdueController {

    private final BookOverdueService bookOverdueService;

    @GetMapping
    public ResponseEntity<List<BookOverdue>> getBookOverdues() {
        return ResponseEntity.ok().body(bookOverdueService.getBookOverdues());
    }

}
