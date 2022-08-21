package com.example.gbswbookmanager;

import com.example.gbswbookmanager.entity.Book;
import com.example.gbswbookmanager.entity.Role;
import com.example.gbswbookmanager.entity.User;
import com.example.gbswbookmanager.service.User.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class GbswBookManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GbswBookManagerApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
//            userService.saveUser(new User(null, "박대일", 2101, "nicenicnic1@gmail.com", "1234", new ArrayList<>(), new ArrayList<>()));
//            userService.saveUser(new User(null, "박대이", 2102, "nicenicnic12@gmail.com", "1234", new ArrayList<>(), new ArrayList<>()));
//            userService.saveUser(new User(null, "박대삼", 2103, "nicenicnic123@gmail.com", "1234", new ArrayList<>(), new ArrayList<>()));
//
//            userService.saveRole(new Role(null, "ROLE_USER"));
//            userService.saveRole(new Role(null, "ROLE_ADMIN"));
//
//            userService.saveBook(new Book(null, "이펙티브 타입스크립트", "대형이", "대형출판사", 5, 4));
//            userService.saveBook(new Book(null, "이펙티브 자바", "대형대형이", "대형출판사", 2, 3));
//            userService.saveBook(new Book(null, "파이썬 기초", "지뇨", "지뇨출판사", 1, 1));
//            userService.saveBook(new Book(null, "파이썬 고급", "지뇨지뇨", "지뇨출판사", 3, 2));
//
//            userService.addRoleToUser("nicenicnic1@gmail.com", "ROLE_USER");
//            userService.addRoleToUser("nicenicnic12@gmail.com", "ROLE_USER");
//            userService.addRoleToUser("nicenicnic123@gmail.com", "ROLE_USER");
//            userService.addRoleToUser("nicenicnic123@gmail.com", "ROLE_ADMIN");
//
//            userService.addBookToUser("nicenicnic1@gmail.com", "이펙티브 타입스크립트");
//            userService.addBookToUser("nicenicnic1@gmail.com", "이펙티브 자바");
//            userService.addBookToUser("nicenicnic12@gmail.com", "파이썬 기초");
//            userService.addBookToUser("nicenicnic123@gmail.com", "이펙티브 타입스크립트");
//            userService.addBookToUser("nicenicnic123@gmail.com", "이펙티브 자바");
//            userService.addBookToUser("nicenicnic123@gmail.com", "파이썬 고급");
        };
    }

}
