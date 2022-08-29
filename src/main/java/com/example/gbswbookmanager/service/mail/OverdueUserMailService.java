package com.example.gbswbookmanager.service.mail;

import javax.mail.internet.MimeMessage;

public interface OverdueUserMailService {

    // 이메일 폼을 만듦
    public MimeMessage createExtensionUserMessage(String name, String email, String bookTitle) throws Exception;

    // 이메일을 보냄
    public void sendExtensionUserMail(String name, String email, String bookTitle) throws Exception;

}
