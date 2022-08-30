package com.example.gbswbookmanager.service.bookOverdue;

import com.example.gbswbookmanager.entity.BookOverdue;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookOverdueService {

    public List<BookOverdue> getBookOverdues();

}
