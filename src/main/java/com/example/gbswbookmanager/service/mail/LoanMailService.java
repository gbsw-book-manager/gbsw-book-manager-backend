package com.example.gbswbookmanager.service.mail;

import javax.mail.internet.MimeMessage;

public interface LoanMailService {

    // 이메일 폼을 만듦
    public MimeMessage createLoanMessage(String name, String email, String bookTitle) throws Exception;

    // 이메일을 보냄
    public void sendLoanMail(String name, String email, String bookTitle) throws Exception;

}
