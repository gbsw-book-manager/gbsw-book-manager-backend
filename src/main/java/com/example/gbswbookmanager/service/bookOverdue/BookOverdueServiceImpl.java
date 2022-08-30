package com.example.gbswbookmanager.service.bookOverdue;

import com.example.gbswbookmanager.entity.BookOverdue;
import com.example.gbswbookmanager.repository.BookOverdueRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookOverdueServiceImpl implements BookOverdueService {

    private final BookOverdueRepository bookOverdueRepository;

    @Override
    public List<BookOverdue> getBookOverdues() {
        return bookOverdueRepository.findAll();
    }
}
