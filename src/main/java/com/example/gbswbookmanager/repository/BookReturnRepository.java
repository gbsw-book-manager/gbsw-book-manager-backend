package com.example.gbswbookmanager.repository;

import com.example.gbswbookmanager.entity.BookLoan;
import com.example.gbswbookmanager.entity.BookReturn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookReturnRepository extends JpaRepository<BookReturn, Long> {
}
