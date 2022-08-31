package com.example.gbswbookmanager.service.bookOverdue;

import com.example.gbswbookmanager.dto.BookOverdueDto;
import com.example.gbswbookmanager.entity.Book;
import com.example.gbswbookmanager.entity.BookLoan;
import com.example.gbswbookmanager.entity.BookOverdue;
import com.example.gbswbookmanager.entity.User;
import com.example.gbswbookmanager.repository.BookLoanRepository;
import com.example.gbswbookmanager.repository.BookOverdueRepository;
import com.example.gbswbookmanager.repository.BookRepository;
import com.example.gbswbookmanager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookOverdueServiceImpl implements BookOverdueService {

    private final UserRepository userRepository;

    private final BookRepository bookRepository;

    private final BookLoanRepository bookLoanRepository;

    private final BookOverdueRepository bookOverdueRepository;

    @Override
    public List<BookOverdueDto> getBookOverdues() {
        List<BookOverdue> overdueList = bookOverdueRepository.findAll();
        List<BookOverdueDto> overdueInfoList = new ArrayList<>();

        for (BookOverdue overdueInfo : overdueList) {
            User user = userRepository.findById(overdueInfo.getUserId()).orElseThrow(NullPointerException::new);
            Book book = bookRepository.findById(overdueInfo.getBookId()).orElseThrow(NullPointerException::new);

            BookLoan bookLoan = bookLoanRepository.findByUserIdAndBookId(overdueInfo.getUserId(), overdueInfo.getBookId());

            overdueInfoList.add(new BookOverdueDto(user.getName(), user.getStuden_id(), book.getTitle(), bookLoan.getLoanDate()));
        }
        return overdueInfoList;
    }
}
