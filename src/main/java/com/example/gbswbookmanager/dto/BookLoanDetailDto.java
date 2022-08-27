package com.example.gbswbookmanager.dto;

import com.example.gbswbookmanager.entity.Book;
import lombok.Data;

@Data
public class BookLoanDetailDto {

    private Long id;

    private String name;

    private Book book;

    public BookLoanDetailDto(Long id, String name, Book book) {
        this.id = id;
        this.name = name;
        this.book = book;
    }
}
