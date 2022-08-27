package com.example.gbswbookmanager.dto;

import lombok.Data;

import java.util.List;

@Data
public class BookReturnDto {

    private Long userId;

    private List<String> bookTitle;

}
