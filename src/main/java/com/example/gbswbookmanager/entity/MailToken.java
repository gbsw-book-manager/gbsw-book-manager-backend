package com.example.gbswbookmanager.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class MailToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String code;

    private LocalDateTime expirationDate;

    private boolean expired;

    public static MailToken createEmailToken(String email, String code) {
        MailToken emailToken = new MailToken();
        emailToken.email = email;
        emailToken.code = code;
        emailToken.expirationDate = LocalDateTime.now().plusMinutes(3L); // 3분 후 만료
        emailToken.expired = false;
        return emailToken;
    }

    public void setTokenToUsed() {
        this.expired = true;
    }

}
