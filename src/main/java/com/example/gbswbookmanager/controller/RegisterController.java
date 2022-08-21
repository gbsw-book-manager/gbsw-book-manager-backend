package com.example.gbswbookmanager.controller;

import com.example.gbswbookmanager.dto.RegisterInfo;
import com.example.gbswbookmanager.service.Mail.MailService;
import com.example.gbswbookmanager.service.User.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

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
    public void register(@RequestBody RegisterInfo registerInfo) {
        String email = registerInfo.getUsername();
        String code = registerInfo.getCode();

        if (userService.checkUserEmail(email)) {
            if (mailService.checkCode(email, code)) {
                userService.saveUser(registerInfo);
                userService.addRoleToUser(email, "ROLE_USER");
            } else {
                log.info("code is Inconsistency");
            }
        } else {
            log.info("User is in the Database");
        }
    }
}
