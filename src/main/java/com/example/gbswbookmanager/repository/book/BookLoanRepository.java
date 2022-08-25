package com.example.gbswbookmanager.repository.book;

import com.example.gbswbookmanager.entity.book.BookLoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookLoanRepository extends JpaRepository<BookLoan, Long> {

    List<Long> findAllById(Long userId);
}
