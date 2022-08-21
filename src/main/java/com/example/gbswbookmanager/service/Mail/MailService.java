package com.example.gbswbookmanager.service.Mail;

import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

@Service
public interface MailService {

    public MimeMessage createMessage(String name, String email) throws Exception;

    public void sendMail(String name, String email) throws Exception;

    public Boolean checkCode(String email, String code);

}
