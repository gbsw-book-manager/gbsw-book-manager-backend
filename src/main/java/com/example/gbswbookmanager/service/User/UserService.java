package com.example.gbswbookmanager.service.User;

import com.example.gbswbookmanager.entity.Book;
import com.example.gbswbookmanager.dto.RegisterInfo;
import com.example.gbswbookmanager.entity.Role;
import com.example.gbswbookmanager.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public User getUser(String username);

    public List<User> getUsers();

    public void saveUser(RegisterInfo registerInfo);

    public Boolean checkUserEmail(String email);

    public void addRoleToUser(String username, String roleName);

    public void addBookToUser(String username, String bookName);

    //
    public Role saveRole(Role role);

}
