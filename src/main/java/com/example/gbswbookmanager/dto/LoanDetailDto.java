package com.example.gbswbookmanager.dto;

import com.example.gbswbookmanager.entity.Book;
import lombok.Data;

@Data
public class LoanDetailDto {

    private String name;

    private Book book;

    public LoanDetailDto(String name, Book book) {
        this.name = name;
        this.book = book;
    }
}
