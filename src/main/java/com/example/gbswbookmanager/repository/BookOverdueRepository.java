package com.example.gbswbookmanager.repository;

import com.example.gbswbookmanager.entity.BookOverdue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookOverdueRepository extends JpaRepository<BookOverdue, Long> {

    public BookOverdue findByUserIdAndBookId(Long userId, Long bookId);

}
