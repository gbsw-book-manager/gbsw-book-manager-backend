package com.example.gbswbookmanager.repository;

import com.example.gbswbookmanager.entity.BookApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookApplicationRepository extends JpaRepository<BookApplication, Long> {

}
