package com.example.gbswbookmanager.controller;

import com.example.gbswbookmanager.dto.RegisterDto;
import com.example.gbswbookmanager.service.Mail.MailService;
import com.example.gbswbookmanager.service.User.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class RegisterController {

    private final UserService userService;

    private final MailService mailService;

    @PostMapping("/certification-email")
    public void certificationEmail(@RequestParam("email") String email, @RequestParam("name") String name) throws Exception {
        mailService.sendMail(name, email);
    }

    @PostMapping("/sign-up")
    public void register(@RequestBody RegisterDto registerDto) {
        String email = registerDto.getUsername();
        String code = registerDto.getCode();

        if (userService.checkUserEmail(email)) {
            if (mailService.checkCode(email, code)) {
                userService.saveUser(registerDto);
                userService.addRoleToUser(email, "ROLE_USER");
            } else {
                log.info("code is Inconsistency");
            }
        } else {
            log.info("User is in the Database");
        }
    }
}
