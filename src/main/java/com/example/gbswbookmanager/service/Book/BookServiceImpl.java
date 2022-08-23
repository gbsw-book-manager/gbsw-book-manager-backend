package com.example.gbswbookmanager.service.Book;

import com.example.gbswbookmanager.dto.BookDto;
import com.example.gbswbookmanager.entity.Book;
import com.example.gbswbookmanager.entity.User;
import com.example.gbswbookmanager.repository.BookRepository;
import com.example.gbswbookmanager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final UserRepository userRepository;

    private final BookRepository bookRepository;

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
    public List<String> getUserNameByBookId(Long id) {
        List<User> users = userRepository.findAll();
        List<String> username = new ArrayList<>();
        for (User user : users) {
            user.getBooks().forEach(
                    book -> {
                        if (Objects.equals(book.getId(), id)) {
                            username.add(user.getName());
                        }
                    }
            );
        }
        return username;
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

    @Override
    public Boolean checkBookExistence(String title) {
        Book book = bookRepository.findByTitle(title);

        return book != null;
    }
}
