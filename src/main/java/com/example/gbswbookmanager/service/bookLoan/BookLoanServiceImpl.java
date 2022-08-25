package com.example.gbswbookmanager.service.bookLoan;

import com.example.gbswbookmanager.dto.LoanDetailDto;
import com.example.gbswbookmanager.dto.LoanDto;
import com.example.gbswbookmanager.entity.User;
import com.example.gbswbookmanager.entity.Book;
import com.example.gbswbookmanager.entity.BookLoan;
import com.example.gbswbookmanager.repository.BookLoanRepository;
import com.example.gbswbookmanager.repository.BookRepository;
import com.example.gbswbookmanager.repository.UserRepository;
import com.example.gbswbookmanager.service.mail.LoanMailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class BookLoanServiceImpl implements BookLoanService {

    private final UserRepository userRepository;

    private final BookRepository bookRepository;

    private final BookLoanRepository bookLoanRepository;

    private final LoanMailService loanMailService;

    @Override
    public Boolean checkBookLoan(LoanDto loanDto) {
        User user = userRepository.findById(loanDto.getUserId()).orElseThrow(NullPointerException::new);
        List<Long> bookIdList = loanDto.getBookId();

        // 유저가 책을 5권 이상 빌렸는 지 확인
        if (user.getBooks().size() == 5) {
            log.info("0");
            return false;
        }

        // 유저가 대출한 책에서 빌리려하는 책이 있는 지 확인
        for (Book book : user.getBooks()) {
            if (bookIdList.contains(book.getId())) {
                log.info("1");
                return false;
            }
        }

        // 유저가 대출 신청한 책에서 빌리려하는 책이 있는 지 확인
        List<BookLoan> bookLoanList = bookLoanRepository.findAll();

        for (BookLoan bookLoan : bookLoanList) {
            // 빌리려는 책의 수량이 남는 지 확인
            Book book = bookRepository.findById(bookLoan.getBookId()).orElseThrow(NullPointerException::new);
            if (book.getQuantityleft() == 0) {
                log.info("2");
                return false;
            }

            if (bookLoan.getUserId().equals(loanDto.getUserId())) {
                if (bookIdList.contains(bookLoan.getBookId())) {
                    log.info("3");
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
            loanDetail.add(new LoanDetailDto(bookLoan.getId() , user.getName(), book));
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

    @Override
    public void loanApproval(Long id) throws Exception {
        BookLoan bookLoan = bookLoanRepository.findById(id).orElseThrow(NullPointerException::new);
        User user = userRepository.findById(bookLoan.getUserId()).orElseThrow(NullPointerException::new);
        Book book = bookRepository.findById(bookLoan.getBookId()).orElseThrow(NullPointerException::new);

        book.setQuantityleft(book.getQuantityleft() - 1);

        user.getBooks().add(book);
        bookLoanRepository.deleteById(id);
        bookRepository.save(book);

        loanMailService.sendLoanMail(user.getName(), user.getUsername(), book.getTitle());
    }

    @Override
    public void refuseBookLoan(Long id) {
        bookLoanRepository.deleteById(id);
    }
}
