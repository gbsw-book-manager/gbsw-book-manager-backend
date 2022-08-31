package com.example.gbswbookmanager.repository;

import com.example.gbswbookmanager.entity.BookLoan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookLoanRepository extends JpaRepository<BookLoan, Long> {

    public BookLoan findByUserIdAndBookId(Long userId, Long bookId);

}
