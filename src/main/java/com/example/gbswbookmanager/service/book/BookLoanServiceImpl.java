package com.example.gbswbookmanager.service.book;

import com.example.gbswbookmanager.dto.LoanDetailDto;
import com.example.gbswbookmanager.dto.LoanDto;
import com.example.gbswbookmanager.entity.User;
import com.example.gbswbookmanager.entity.book.Book;
import com.example.gbswbookmanager.entity.book.BookLoan;
import com.example.gbswbookmanager.repository.book.BookLoanRepository;
import com.example.gbswbookmanager.repository.book.BookRepository;
import com.example.gbswbookmanager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookLoanServiceImpl implements BookLoanService {

    private final UserRepository userRepository;

    private final BookRepository bookRepository;

    private final BookLoanRepository bookLoanRepository;

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
    public List<LoanDetailDto> getBookLoanList() {
        List<BookLoan> loanList = bookLoanRepository.findAll();
        List<LoanDetailDto> loanDetail = new ArrayList<>();
        for (BookLoan bookLoan : loanList) {
            User user = userRepository.findById(bookLoan.getUserId()).orElseThrow(NullPointerException::new);
            Book book = bookRepository.findById(bookLoan.getBookId()).orElseThrow(NullPointerException::new);
            loanDetail.add(new LoanDetailDto(user.getName(), book));
        }
        return loanDetail;
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

}
