package com.example.gbswbookmanager.service.book;

import com.example.gbswbookmanager.dto.BookDto;
import com.example.gbswbookmanager.dto.LoanDto;
import com.example.gbswbookmanager.dto.LoanDetailDto;
import com.example.gbswbookmanager.entity.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {

    // 책이 DB에 존재하는지 여부 확인
    public Boolean checkBookExistence(String title);

    // 대출하기를 눌렀을 때 이미 빌린 책이 포함되어 있는 지 학인
    public Boolean checkBookLoan(LoanDto loanDto);

    // BookDto를 통해서 Book을 새로 만듦
    public Book setBook(BookDto bookDto);

    // Id로 DB에서 책 정보 가져오기
    public Book getBook(Long id);

    // 모든 책 리스트 가져오기
    public List<Book> getBooks();

    // 모든 대출 리스트 가져오기
    public List<LoanDetailDto> getBookLoan();

    // 책 DB에 저장
    public void addBook(Book book);

    // 사용자가 책을 빌림
    public void bookLoan(LoanDto loanDto);

    // 책 DB 정보 수정
    public void updateBook(Book book);

    // 책 수량 DB 정보 수정
    public void updateBookQuantity(BookDto bookDto);

    // Id를 통해 DB에서 책 삭제
    public void deleteBook(Long id);

//    public void bookReturn(String username, String bookTitle);

}