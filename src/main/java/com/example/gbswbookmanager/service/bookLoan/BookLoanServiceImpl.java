package com.example.gbswbookmanager.service.bookLoan;

import com.example.gbswbookmanager.dto.BookLoanDetailDto;
import com.example.gbswbookmanager.dto.BookLoanDto;
import com.example.gbswbookmanager.entity.BookLoan;
import com.example.gbswbookmanager.entity.User;
import com.example.gbswbookmanager.entity.Book;
import com.example.gbswbookmanager.entity.BookLoanApplication;
import com.example.gbswbookmanager.repository.BookLoanApplicationRepository;
import com.example.gbswbookmanager.repository.BookLoanRepository;
import com.example.gbswbookmanager.repository.BookRepository;
import com.example.gbswbookmanager.repository.UserRepository;
import com.example.gbswbookmanager.service.mail.LoanMailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
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

    private final BookLoanApplicationRepository bookLoanApplicationRepository;

    private final LoanMailService loanMailService;

    @Override
    public Boolean checkBookLoan(BookLoanDto BookLoanDto) {
        User user = userRepository.findById(BookLoanDto.getUserId()).orElseThrow(NullPointerException::new);
        List<Long> bookIdList = BookLoanDto.getBookId();

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
        List<BookLoanApplication> bookLoanApplicationList = bookLoanApplicationRepository.findAll();

        for (BookLoanApplication bookLoanApplication : bookLoanApplicationList) {
            // 빌리려는 책의 수량이 남는 지 확인
            Book book = bookRepository.findById(bookLoanApplication.getBookId()).orElseThrow(NullPointerException::new);
            if (book.getQuantityleft() == 0) {
                log.info("2");
                return false;
            }

            if (bookLoanApplication.getUserId().equals(BookLoanDto.getUserId())) {
                if (bookIdList.contains(bookLoanApplication.getBookId())) {
                    log.info("3");
                    return false;
                }
             }
        }
        return true;
    }

    @Override
    public List<BookLoanDetailDto> getBookLoanList() {
        List<BookLoanApplication> loanList = bookLoanApplicationRepository.findAll();
        List<BookLoanDetailDto> loanDetail = new ArrayList<>();
        for (BookLoanApplication bookLoanApplication : loanList) {
            User user = userRepository.findById(bookLoanApplication.getUserId()).orElseThrow(NullPointerException::new);
            Book book = bookRepository.findById(bookLoanApplication.getBookId()).orElseThrow(NullPointerException::new);
            loanDetail.add(new BookLoanDetailDto(bookLoanApplication.getId() , user.getName(), book));
        }
        return loanDetail;
    }

    @Override
    public void bookLoan(BookLoanDto BookLoanDto) {
        Long userId = BookLoanDto.getUserId();
        List<Long> bookIdList = BookLoanDto.getBookId();

        for (Long bookId : bookIdList) {
            bookLoanApplicationRepository.save(new BookLoanApplication(
                    null,
                    userId,
                    bookId
            ));
        }
    }

    @Override
    public void loanApproval(Long id) throws Exception {
        BookLoanApplication bookLoanApplication = bookLoanApplicationRepository.findById(id).orElseThrow(NullPointerException::new);
        User user = userRepository.findById(bookLoanApplication.getUserId()).orElseThrow(NullPointerException::new);
        Book book = bookRepository.findById(bookLoanApplication.getBookId()).orElseThrow(NullPointerException::new);
        LocalDate loanDate = LocalDate.now();

        book.setQuantityleft(book.getQuantityleft() - 1);

        user.getBooks().add(book);
        bookLoanRepository.save(new BookLoan(null, user.getId(), book.getId(), loanDate, false, false));

        bookLoanApplicationRepository.deleteById(id);
        loanMailService.sendLoanMail(user.getName(), user.getUsername(), book.getTitle(), loanDate.plusMonths(1));
    }

    @Override
    public void refuseBookLoan(Long id) {
        bookLoanApplicationRepository.deleteById(id);
    }
}
