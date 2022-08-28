package com.example.gbswbookmanager.service.book;

import com.example.gbswbookmanager.dto.BookDto;
import com.example.gbswbookmanager.entity.Book;
import com.example.gbswbookmanager.entity.BookLoan;
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

    @Override
    public Boolean checkBookExistence(String title) {
        Book book = bookRepository.findByTitle(title);

        return book != null;
    }

    @Override
    public Boolean checkBookQuantity(Long id) {
        BookLoan bookLoan = bookLoanRepository.findById(id).orElseThrow(NullPointerException::new);
        Book book = bookRepository.findById(bookLoan.getBookId()).orElseThrow(NullPointerException::new);

        return book.getQuantityleft() != 0;
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
    public void addBook(Book book) {
        bookRepository.save(book);
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
