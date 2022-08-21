package com.example.gbswbookmanager.service.Book;

import com.example.gbswbookmanager.entity.Book;
import com.example.gbswbookmanager.entity.Role;
import com.example.gbswbookmanager.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {

    public List<Book> getBooks();

}
