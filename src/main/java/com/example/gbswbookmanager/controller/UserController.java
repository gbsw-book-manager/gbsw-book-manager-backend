package com.example.gbswbookmanager.controller;

import com.example.gbswbookmanager.config.auth.PrincipalDetails;
import com.example.gbswbookmanager.dto.PasswordDto;
import com.example.gbswbookmanager.dto.RegisterDto;
import com.example.gbswbookmanager.dto.UserLoanDto;
import com.example.gbswbookmanager.entity.Book;
import com.example.gbswbookmanager.entity.User;
import com.example.gbswbookmanager.service.mail.AuthMailService;
import com.example.gbswbookmanager.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private final AuthMailService authMailService;

    @GetMapping("/user")
    public ResponseEntity<List<UserLoanDto>> getUserLoanBooks(@RequestParam Long id) {
        return ResponseEntity.ok().body(userService.getUserLoanBooks(id));
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok().body(userService.getUsersExceptAdmin());
    }

    @PostMapping("/certification-email")
    public ResponseEntity<?> certificationEmail(@RequestParam("email") String email, @RequestParam("name") String name) throws Exception {
        if (userService.checkUserEmail(email)) {
            authMailService.sendAuthMail(name, email);
            return ResponseEntity.ok("이메일 인증 성공");
        } else {
            return ResponseEntity.ok("이메일이 이미 존재함");
        }
    }

    @PostMapping("/sign-up")
    public ResponseEntity<?> register(@RequestBody RegisterDto registerDto) {
        String email = registerDto.getUsername();
        String code = registerDto.getCode();

        if (userService.checkUserEmail(email)) {
            if (authMailService.checkAuthCode(email, code)) {
                if (userService.checkStudentId(registerDto.getStudentId())) {
                    userService.saveUser(registerDto);
                    userService.addRoleToUser(email, "ROLE_USER");
                    return ResponseEntity.ok("회원가입 성공");
                } else {
                    return ResponseEntity.ok("학번이 이미 존재함");
                }
            } else {
                return ResponseEntity.ok("인증 코드 불일치");
            }
        } else {
            return ResponseEntity.ok("유저가 이미 있음");
        }
    }

    @PutMapping("/update-password")
    public ResponseEntity<?> updatePassword(@RequestBody PasswordDto passwordDto) {
        if (userService.changePassword(passwordDto)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.ok().body("비밀번호가 일치하지 않거나, 새 비밀번호가 다릅니다.");
        }
    }
}
