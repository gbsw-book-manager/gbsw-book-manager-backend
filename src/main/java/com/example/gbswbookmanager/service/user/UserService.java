package com.example.gbswbookmanager.service.user;

import com.example.gbswbookmanager.dto.PasswordDto;
import com.example.gbswbookmanager.dto.RegisterDto;
import com.example.gbswbookmanager.dto.UserLoanDto;
import com.example.gbswbookmanager.entity.Book;
import com.example.gbswbookmanager.entity.Role;
import com.example.gbswbookmanager.entity.User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
public interface UserService {

    // 사용자가 회원가입 했는 지 확인
    public Boolean checkUserEmail(String email);

    public Boolean checkStudentId(String student_id);

    // USERNAME을 통해 DB에서 사용자 검색
    public User getUser(String username);

    // id를 통해 그 사용자가 빌린 책 모두 출력
    public List<UserLoanDto> getUserLoanBooks(Long id);

    public List<User> getUsers();

    // 모든 사용자 검색
    public List<User> getUsersExceptAdmin();

    // Book Id와 참조되어 있는 컬럼 찾기
    public List<String> getUserNameByBookId(Long id);

    // 회원가입 폼을 통해서 DB에 저장
    public void saveUser(RegisterDto registerDto);

    // TEST SERVICE
    public void saveUserTest(User user);

    public Boolean changePassword(PasswordDto passwordDto);

    // 권한을 사용자에게 추가
    public void addRoleToUser(String username, String roleName);

    // 책을 사용자에게 추가(대출)
    public void addBookToUser(String username, String bookName);

    // 권한 추가
    public void saveRole(Role role);

}
