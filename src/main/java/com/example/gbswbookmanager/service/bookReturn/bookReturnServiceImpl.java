package com.example.gbswbookmanager.service.bookReturn;

import com.example.gbswbookmanager.dto.BookReturnDetialDto;
import com.example.gbswbookmanager.dto.BookReturnDto;
import com.example.gbswbookmanager.entity.Book;
import com.example.gbswbookmanager.entity.BookReturn;
import com.example.gbswbookmanager.entity.User;
import com.example.gbswbookmanager.repository.BookRepository;
import com.example.gbswbookmanager.repository.BookReturnRepository;
import com.example.gbswbookmanager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class bookReturnServiceImpl implements BookReturnService {

    private final UserRepository userRepository;

    private final BookRepository bookRepository;

    private final BookReturnRepository bookReturnRepository;

    @Override
    public Boolean checkBookReturn(BookReturnDto bookReturnDto) {
        List<BookReturn> bookReturnList = bookReturnRepository.findAll();
        List<String> bookTitleList = bookReturnDto.getBookTitle();

        // bookReturn테이블을 다 가져와서 하나씩 돌려봄
        for (BookReturn bookReturn : bookReturnList) {
            // 하나씩 돌려보는데 userId가 같으면 다음
            if (bookReturn.getUserId().equals(bookReturnDto.getUserId())) {
                // 그리고 하나씩 가져온 거 중에 책 이름이 반납할려는 책 목록에 있으면 false
                if (bookTitleList.contains(bookReturn.getBookTitle())) {
                    log.info("2");
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public List<BookReturnDetialDto> getBookReturns() {
        List<BookReturn> returnList = bookReturnRepository.findAll();
        List<BookReturnDetialDto> returnDetail = new ArrayList<>();
        for (BookReturn bookReturn : returnList) {
            User user = userRepository.findById(bookReturn.getUserId()).orElseThrow(NullPointerException::new);
            Book book = bookRepository.findByTitle(bookReturn.getBookTitle());
            returnDetail.add(new BookReturnDetialDto(bookReturn.getId() , user.getName(), book));
        }
        return returnDetail;
    }

    @Override
    public void bookReturn(BookReturnDto bookReturnDto) {
        Long userId = bookReturnDto.getUserId();
        List<String> bookTitleList = bookReturnDto.getBookTitle();

        for (String bookTitle : bookTitleList) {
            bookReturnRepository.save(new BookReturn(
                    null,
                    userId,
                    bookTitle
            ));
        }
    }

    @Override
    public void bookReturnApproval(Long returnId) {
        BookReturn bookReturn = bookReturnRepository.findById(returnId).orElseThrow(NullPointerException::new);

        User user = userRepository.findById(bookReturn.getUserId()).orElseThrow(NullPointerException::new);
        Book book = bookRepository.findByTitle(bookReturn.getBookTitle());

        user.getBooks().remove(book);
        book.setQuantityleft(book.getQuantityleft() + 1);

        bookRepository.save(book);
        bookReturnRepository.deleteById(returnId);
    }
}
