package com.example.gbswbookmanager.repository.book;

import com.example.gbswbookmanager.entity.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    public Book findByTitle(String title);

}
