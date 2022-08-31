package com.example.gbswbookmanager.dto;

import com.example.gbswbookmanager.entity.Book;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserLoanDto {

    private Book book;

    private LocalDate loanDate;

    public UserLoanDto(Book book, LocalDate loanDate) {
        this.book = book;
        this.loanDate = loanDate;
    }

}
