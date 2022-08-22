package com.example.gbswbookmanager.service.User;

import com.example.gbswbookmanager.entity.Book;
import com.example.gbswbookmanager.dto.RegisterDto;
import com.example.gbswbookmanager.entity.Role;
import com.example.gbswbookmanager.entity.User;
import com.example.gbswbookmanager.repository.BookRepository;
import com.example.gbswbookmanager.repository.RoleRepository;
import com.example.gbswbookmanager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final BookRepository bookRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public User getUser(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public void saveUser(RegisterDto registerDto) {
        log.info("Saving new User {} to the database", registerDto.getName());
        User user = new User();
        user.setName(registerDto.getName());
        user.setStuden_id(registerDto.getStudentId());
        user.setUsername(registerDto.getUsername());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        user.setRoles(new ArrayList<>());
        user.setBooks(new ArrayList<>());
        userRepository.save(user);
    }

    @Override
    public Boolean checkUserEmail(String email) {
        User user = userRepository.findByUsername(email);
        log.info("user : {}", user);

        return user == null;
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
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

}