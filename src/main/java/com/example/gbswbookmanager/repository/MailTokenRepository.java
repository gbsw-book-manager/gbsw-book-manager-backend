package com.example.gbswbookmanager.repository;

import com.example.gbswbookmanager.entity.AuthMailToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface MailTokenRepository extends JpaRepository<AuthMailToken, Long> {

    // 만료되지 않았으며 현재보다 이후에 만료되는 토큰정보를 가져온다.
    AuthMailToken findByEmailAndExpirationDateAfterAndExpired(String email, LocalDateTime now, boolean expired);

}
