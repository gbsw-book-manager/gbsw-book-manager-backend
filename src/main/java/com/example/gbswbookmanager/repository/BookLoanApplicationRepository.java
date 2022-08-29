package com.example.gbswbookmanager.repository;

import com.example.gbswbookmanager.entity.BookLoanApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookLoanApplicationRepository extends JpaRepository<BookLoanApplication, Long> {
}
