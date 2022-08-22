package com.example.gbswbookmanager.service.Book;

import com.example.gbswbookmanager.dto.BookDto;
import com.example.gbswbookmanager.entity.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {

    // Id로 DB에서 책 정보 가져오기
    public Book getBook(Long id);

    // 모든 책 리스트 가져오기
    public List<Book> getBooks();

    // 책 DB에 저장
    public void addBook(Book book);

    // 책 DB 정보 수정
    public void updateBook(Book book);

    // 책 수량 DB 정보 수정
    public void updateBookQuantity(BookDto bookDto);

    // Id를 통해 DB에서 책 삭제
    public void deleteBook(Long id);

    // 책이 DB에 존재하는지 여부 확인
    public Boolean checkBookExistence(String title);

}
