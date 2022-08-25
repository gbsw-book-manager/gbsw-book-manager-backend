package com.example.gbswbookmanager.service.bookApplication;

import com.example.gbswbookmanager.entity.BookApplication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookApplicationService {

    // 희망도서 신청 목록 가져오기
    public List<BookApplication> getBookApplications();

    // 희망도서 신청하기
    public void addBookApplication(BookApplication bookApplication);

    public void deleteApplication(Long id);

}
