package com.example.gbswbookmanager.dto;

import com.example.gbswbookmanager.entity.Book;
import lombok.Data;

@Data
public class LoanResponseDto {

    private String name;

    private Book book;

    public LoanResponseDto(String name, Book book) {
        this.name = name;
        this.book = book;
    }
}
