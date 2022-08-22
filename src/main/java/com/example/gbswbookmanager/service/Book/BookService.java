package com.example.gbswbookmanager.service.Book;

import com.example.gbswbookmanager.dto.BookDto;
import com.example.gbswbookmanager.entity.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {

    // 모든 책 리스트 가져오기
    public List<Book> getBooks();

    // 책 DB에 저장
    public void saveBook(Book book);

    // 책 수량 DB 정보 업데이트
    public void updateBookQuantity(BookDto bookDto);

    // 책이 DB에 존재하는지 여부 확인
    public Boolean checkBookExistence(String title);

}
