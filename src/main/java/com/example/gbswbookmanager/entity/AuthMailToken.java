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
public class AuthMailToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String code;

    private LocalDateTime expirationDate;

    private boolean expired;

    public static AuthMailToken createEmailToken(String email, String code) {
        AuthMailToken emailTokenAuth = new AuthMailToken();
        emailTokenAuth.email = email;
        emailTokenAuth.code = code;
        emailTokenAuth.expirationDate = LocalDateTime.now().plusMinutes(3L); // 3분 후 만료
        emailTokenAuth.expired = false;
        return emailTokenAuth;
    }

    public void setTokenToUsed() {
        this.expired = true;
    }

}
