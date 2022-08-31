package com.example.gbswbookmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class BookOverdueDto {

    private String name;

    private String studentId;

    private String bookTitle;

    private LocalDate loanDate;

}
