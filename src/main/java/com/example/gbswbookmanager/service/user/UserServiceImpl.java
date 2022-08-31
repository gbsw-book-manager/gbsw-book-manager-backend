package com.example.gbswbookmanager.service.user;

import com.example.gbswbookmanager.dto.PasswordDto;
import com.example.gbswbookmanager.dto.UserLoanDto;
import com.example.gbswbookmanager.entity.Book;
import com.example.gbswbookmanager.dto.RegisterDto;
import com.example.gbswbookmanager.entity.BookLoan;
import com.example.gbswbookmanager.entity.Role;
import com.example.gbswbookmanager.entity.User;
import com.example.gbswbookmanager.repository.BookLoanRepository;
import com.example.gbswbookmanager.repository.BookRepository;
import com.example.gbswbookmanager.repository.RoleRepository;
import com.example.gbswbookmanager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.*;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final BookRepository bookRepository;

    private final BookLoanRepository bookLoanRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public Boolean checkUserEmail(String email) {
        User user = userRepository.findByUsername(email);
        log.info("user : {}", user);

        return user == null;
    }

    @Override
    public User getUser(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<UserLoanDto> getUserLoanBooks(Long id) {
        User user = userRepository.findById(id).orElseThrow(NullPointerException::new);
        List<UserLoanDto> userLoanList = new ArrayList<>();

        for (Book bookLoan : user.getBooks()) {
            BookLoan book = bookLoanRepository.findByUserIdAndBookId(id, bookLoan.getId());
            userLoanList.add(new UserLoanDto(bookLoan, book.getLoanDate()));
        }

        return userLoanList;
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getUsersExceptAdmin() {
        List<User> userList = userRepository.findAll();
        List<User> users = new ArrayList<>(userList);

        for (User user : userList) {
            for (Role userRole : user.getRoles()) {
                if (userRole.getName().contains("ROLE_ADMIN")) {
                    users.remove(user);
                }
            }
        }
        return users;
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
    public void saveUser(RegisterDto registerDto) {
        log.info("Saving new User {} to the database", registerDto.getName());
        User user = new User(
                null,
                registerDto.getName(),
                registerDto.getStudentId(),
                registerDto.getUsername(),
                passwordEncoder.encode(registerDto.getPassword()),
                new ArrayList<>(),
                new ArrayList<>()
        );
        userRepository.save(user);
    }

    @Override
    public void saveUserTest(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public Boolean changePassword(PasswordDto passwordDto) {
        User user = userRepository.findByUsername(passwordDto.getUsername());

        if (passwordEncoder.matches(passwordDto.getPassword(), user.getPassword())) {
            if (passwordDto.getNewPassword().equals(passwordDto.getNewPasswordCheck())) {
                user.setPassword(passwordEncoder.encode(passwordDto.getNewPassword()));
                userRepository.save(user);
                return true;
            }
            log.info("1");
            return false;
        }
        log.info("2");
        return false;
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        User user = userRepository.findByUsername(username);
        Role role = roleRepository.findByName(roleName);
        user.getRoles().add(role);
    }

    @Override
    public void addBookToUser(String username, String title) {
        User user = userRepository.findByUsername(username);
        Book book = bookRepository.findByTitle(title);
        user.getBooks().add(book);
    }

    @Override
    public void saveRole(Role role) {
        roleRepository.save(role);
    }

}