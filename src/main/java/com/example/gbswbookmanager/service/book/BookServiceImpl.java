package com.example.gbswbookmanager.service.book;

import com.example.gbswbookmanager.dto.BookDto;
import com.example.gbswbookmanager.dto.LoanDto;
import com.example.gbswbookmanager.dto.LoanDetailDto;
import com.example.gbswbookmanager.entity.Book;
import com.example.gbswbookmanager.entity.BookLoan;
import com.example.gbswbookmanager.entity.User;
import com.example.gbswbookmanager.repository.BookLoanRepository;
import com.example.gbswbookmanager.repository.BookRepository;
import com.example.gbswbookmanager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final UserRepository userRepository;

    private final BookRepository bookRepository;

    private final BookLoanRepository bookLoanRepository;

    @Override
    public Boolean checkBookExistence(String title) {
        Book book = bookRepository.findByTitle(title);

        return book != null;
    }

    @Override
    public Boolean checkBookLoan(LoanDto loanDto) {
        List<BookLoan> bookLoanList = bookLoanRepository.findAll();

        Long userId = loanDto.getUserId();
        List<Long> bookIdList = loanDto.getBookId();

        for (BookLoan bookLoan : bookLoanList) {
            if (Objects.equals(bookLoan.getUserId(), userId)) {
                if (bookIdList.contains(bookLoan.getBookId())) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public Book setBook(BookDto bookDto) {
        return new Book(
                null,
                bookDto.getTitle(),
                bookDto.getAuthor(),
                bookDto.getPublisher(),
                bookDto.getQuantity(),
                bookDto.getQuantity()
        );
    }

    @Override
    public Book getBook(Long id) {
        return bookRepository.findById(id).orElseThrow(NullPointerException::new);
    }

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Override
    public List<LoanDetailDto> getBookLoan() {
        List<BookLoan> loanList = bookLoanRepository.findAll();
        List<LoanDetailDto> loanDetailList = new ArrayList<>();
        for (BookLoan bookLoan : loanList) {
            User user = userRepository.findById(bookLoan.getUserId()).orElseThrow(NullPointerException::new);
            Book book = bookRepository.findById(bookLoan.getBookId()).orElseThrow(NullPointerException::new);
            loanDetailList.add(new LoanDetailDto(user.getName(), book));
        }
        return loanDetailList;
    }

    @Override
    public void addBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void bookLoan(LoanDto loanDto) {
        Long userId = loanDto.getUserId();
        List<Long> bookIdList = loanDto.getBookId();

        for (Long bookId : bookIdList) {
            bookLoanRepository.save(new BookLoan(
                    null,
                    userId,
                    bookId
            ));
        }
    }

    @Override
    public void updateBook(Book book) {
        Book updatedBook = bookRepository.findById(book.getId()).orElseThrow(NullPointerException::new);

        updatedBook.setTitle(book.getTitle());
        updatedBook.setAuthor(book.getAuthor());
        updatedBook.setPublisher(book.getPublisher());
        updatedBook.setQuantity(book.getQuantity());
        updatedBook.setQuantityleft(book.getQuantityleft());

        bookRepository.save(updatedBook);
    }

    @Override
    public void updateBookQuantity(BookDto bookDto) {
        Book book = bookRepository.findByTitle(bookDto.getTitle());

        book.setQuantity(book.getQuantity() + bookDto.getQuantity());
        book.setQuantityleft(book.getQuantityleft() + bookDto.getQuantity());

        bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(NullPointerException::new);

        bookRepository.delete(book);
    }

}
