package com.example.gbswbookmanager.service.mail;

import javax.mail.internet.MimeMessage;

public interface OverdueAdminMailService {

    // 이메일 폼을 만듦
    public MimeMessage createExtensionAdminMessage(String name, String email, String bookTitle) throws Exception;

    // 이메일을 보냄
    public void sendExtensionAdminMail(String name, String email, String bookTitle) throws Exception;

}
