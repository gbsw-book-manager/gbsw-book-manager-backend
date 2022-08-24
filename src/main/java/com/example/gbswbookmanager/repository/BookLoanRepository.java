package com.example.gbswbookmanager.repository;

import com.example.gbswbookmanager.entity.BookLoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookLoanRepository extends JpaRepository<BookLoan, Long> {

    List<Long> findAllById(Long userId);
}