package com.example.gbswbookmanager.dto;

import lombok.Data;

import java.util.List;

@Data
public class LoanDto {

    private Long userId;

    private List<Long> bookId;

}
