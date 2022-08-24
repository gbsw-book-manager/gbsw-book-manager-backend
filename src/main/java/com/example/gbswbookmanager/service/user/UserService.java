package com.example.gbswbookmanager.service.user;

import com.example.gbswbookmanager.dto.RegisterDto;
import com.example.gbswbookmanager.entity.Role;
import com.example.gbswbookmanager.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    // USERNAME을 통해 DB에서 사용자 검색
    public User getUser(String username);

    // 모든 사용자 검색
    public List<User> getUsers();

    // Book Id와 참조되어 있는 컬럼 찾기
    public List<String> getUserNameByBookId(Long id);

    // 회원가입 폼을 통해서 DB에 저장
    public void saveUser(RegisterDto registerDto);

    // TEST SERVICE
    public void saveUserTest(User user);

    // 사용자가 회원가입 했는 지 확인
    public Boolean checkUserEmail(String email);

    // 권한을 사용자에게 추가
    public void addRoleToUser(String username, String roleName);

    // 책을 사용자에게 추가(대출)
    public void addBookToUser(String username, String bookName);

    // 권한 추가
    public void saveRole(Role role);

}
