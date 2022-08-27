package com.example.gbswbookmanager.controller;

import com.example.gbswbookmanager.dto.BookReturnDetialDto;
import com.example.gbswbookmanager.dto.BookReturnDto;
import com.example.gbswbookmanager.entity.BookReturn;
import com.example.gbswbookmanager.service.bookReturn.BookReturnService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/book/return")
@RequiredArgsConstructor
public class BookReturnController {

    private final BookReturnService bookReturnService;

    @GetMapping
    public ResponseEntity<List<BookReturnDetialDto>> getBookReturns() {
        return ResponseEntity.ok().body(bookReturnService.getBookReturns());
    }

    @PostMapping
    public ResponseEntity<?> bookReturn(@RequestBody BookReturnDto bookReturnDto) {
        log.info("userid : {}", bookReturnDto.getUserId());
        if (bookReturnService.checkBookReturn(bookReturnDto)) {
            bookReturnService.bookReturn(bookReturnDto);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.ok().body("이미 반납 신청을 한 책 입니다.");
    }

    @DeleteMapping
    public ResponseEntity<?> bookReturnApproval(@RequestParam Long id) {
        bookReturnService.bookReturnApproval(id);
        return ResponseEntity.ok().body("반납이 완료되었습니다.");
    }

}
