package com.example.gbswbookmanager.service.bookApplication;

import com.example.gbswbookmanager.entity.BookApplication;
import com.example.gbswbookmanager.repository.BookApplicationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookApplicationServiceImpl implements BookApplicationService {

    private final BookApplicationRepository bookApplicationRepository;

    @Override
    public List<BookApplication> getBookApplications() {
        log.info("Find All Book Applications");
        return bookApplicationRepository.findAll();
    }

    @Override
    public void addBookApplication(BookApplication bookApplication) {
        log.info("{} is add to DB", bookApplication.getTitle());
        bookApplicationRepository.save(bookApplication);
    }
}
