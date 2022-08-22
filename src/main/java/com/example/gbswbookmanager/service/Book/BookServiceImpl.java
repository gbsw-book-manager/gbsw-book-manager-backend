package com.example.gbswbookmanager.service.Book;

import com.example.gbswbookmanager.dto.BookDto;
import com.example.gbswbookmanager.entity.Book;
import com.example.gbswbookmanager.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Override
    public void saveBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void updateBookQuantity(BookDto bookDto) {
        Book book = bookRepository.findByTitle(bookDto.getTitle());

        book.setQuantity(book.getQuantity() + bookDto.getQuantity());
        book.setQuantityleft(book.getQuantityleft() + bookDto.getQuantity());

        bookRepository.save(book);
    }

    @Override
    public Boolean checkBookExistence(String title) {
        Book book = bookRepository.findByTitle(title);

        return book != null;
    }
}
