package com.example.gbswbookmanager.service.Mail;

import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

@Service
public interface MailService {

    // create Email Message Form
    public MimeMessage createMessage(String name, String email) throws Exception;

    // send To
    public void sendMail(String name, String email) throws Exception;

    public Boolean checkCode(String email, String code);

}
