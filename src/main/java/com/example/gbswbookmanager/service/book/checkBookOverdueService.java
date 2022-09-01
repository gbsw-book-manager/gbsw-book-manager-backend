package com.example.gbswbookmanager.service.book;

import com.example.gbswbookmanager.entity.Book;
import com.example.gbswbookmanager.entity.BookOverdue;
import com.example.gbswbookmanager.entity.BookLoan;
import com.example.gbswbookmanager.entity.User;
import com.example.gbswbookmanager.repository.BookLoanRepository;
import com.example.gbswbookmanager.repository.BookOverdueRepository;
import com.example.gbswbookmanager.repository.BookRepository;
import com.example.gbswbookmanager.repository.UserRepository;
import com.example.gbswbookmanager.service.mail.OverdueUserMailService;
import com.example.gbswbookmanager.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class checkBookOverdueService {

    private final BookOverdueRepository bookOverdueRepository;

    private final BookLoanRepository bookLoanRepository;

    private final UserRepository userRepository;

    private final BookRepository bookRepository;

    private final UserService userService;

    private final OverdueUserMailService overdueUserMailService;

    private static final int OVERDUE_DAY = 31;
    private static final int OVERDUE_DAY_EXTENSION = 61;

    @Scheduled(cron = "0 0 0 * * ?") // 1분마다 메소드 실행
    public void checkBookOverdue() throws Exception {
        log.info("check start");

        LocalDate time = LocalDate.now();
        List<User> users = userService.getUsers();
        List<BookLoan> bookLoanList = bookLoanRepository.findAll();

            // 유저가 대출한 모든 책 비교
            for (BookLoan userLoanBook : bookLoanList) {
                // 책이 연체됬는지 안됬는지 확인
                if (!userLoanBook.getOverdue()) {
                    // 책 기한을 연장했는지 확인
                    if (!userLoanBook.getLoanExtension()) {
                        // 연체가 됬다면
                        if (ChronoUnit.DAYS.between(time, userLoanBook.getLoanDate()) > OVERDUE_DAY) {
                            Book book = bookRepository.findById(userLoanBook.getBookId()).orElseThrow(NullPointerException::new);
                            User user = userRepository.findById(userLoanBook.getUserId()).orElseThrow(NullPointerException::new);

                            log.info("beep1: {}", user.getName());
                            userLoanBook.setOverdue(true);
                            bookOverdueRepository.save(new BookOverdue(null, user.getId(), userLoanBook.getId()));
//                            overdueAdminMailService.sendExtensionAdminMail();
                            log.info("username: {}", user.getUsername());
                            overdueUserMailService.sendExtensionUserMail(user.getName(), user.getUsername(), book.getTitle());
                        }
                    } else {
                        if (ChronoUnit.DAYS.between(time, userLoanBook.getLoanDate()) > OVERDUE_DAY_EXTENSION) {
                            Book book = bookRepository.findById(userLoanBook.getBookId()).orElseThrow(NullPointerException::new);
                            User user = userRepository.findById(userLoanBook.getUserId()).orElseThrow(NullPointerException::new);

                            log.info("beep2: {}", user.getName());
                            userLoanBook.setOverdue(true);
                            bookOverdueRepository.save(new BookOverdue(null, user.getId(), userLoanBook.getId()));
//                            overdueAdminMailService.sendExtensionAdminMail();
                            overdueUserMailService.sendExtensionUserMail(user.getName(), user.getUsername(), book.getTitle());
                        }
                    }
                }
            }
        log.info("check end");
    }

}
