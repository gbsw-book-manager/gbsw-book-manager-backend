package com.example.gbswbookmanager.service.mail;

import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

@Service
public interface AuthMailService {

    // 이메일 폼을 만듦
    public MimeMessage createAuthMessage(String name, String email) throws Exception;

    // 이메일을 보냄
    public void sendAuthMail(String name, String email) throws Exception;

    // 인증 코드가 맞는 지 확인
    public Boolean checkAuthCode(String email, String code);

}
