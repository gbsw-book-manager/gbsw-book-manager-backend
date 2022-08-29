package com.example.gbswbookmanager.service.book;

import com.example.gbswbookmanager.dto.BookDto;
import com.example.gbswbookmanager.dto.LoanExtensionDto;
import com.example.gbswbookmanager.entity.Book;
import com.example.gbswbookmanager.entity.BookLoan;
import com.example.gbswbookmanager.entity.BookLoanApplication;
import com.example.gbswbookmanager.repository.BookLoanApplicationRepository;
import com.example.gbswbookmanager.repository.BookLoanRepository;
import com.example.gbswbookmanager.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    private final BookLoanRepository bookLoanRepository;

    private final BookLoanApplicationRepository bookLoanApplicationRepository;

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
    public Boolean checkBookExistence(String title) {
        Book book = bookRepository.findByTitle(title);

        return book != null;
    }

    @Override
    public Boolean checkBookQuantity(Long id) {
        BookLoanApplication bookLoanApplication = bookLoanApplicationRepository.findById(id).orElseThrow(NullPointerException::new);
        Book book = bookRepository.findById(bookLoanApplication.getBookId()).orElseThrow(NullPointerException::new);

        return book.getQuantityleft() != 0;
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
    public void addBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public Boolean bookLoanExtension(LoanExtensionDto loanExtensionDto) {
        Book book = bookRepository.findByTitle(loanExtensionDto.getBookTitle());
        List<BookLoan> bookLoanList = bookLoanRepository.findAll();

        for (BookLoan bookLoan : bookLoanList) {
            if (bookLoan.getUserId().equals(loanExtensionDto.getUserId())) {
                if (loanExtensionDto.getBookTitle().equals(book.getTitle())) {
                    bookLoan.setLoanExtension(true);
                    log.info("heeeeeeeeeeeeep");
                    return true;
                }
            }
        }
        return false;
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
