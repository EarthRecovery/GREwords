package com.BetterGREwords.service;

import com.BetterGREwords.model.User;
import com.BetterGREwords.repository.UserDAO;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public User findByUsername(String username) {
        return userDAO.findByUsername(username);
    }

    public boolean createUser(String username, String email, String password_hash) {
        User user = new User(username, email, password_hash);
        userDAO.save(user);
        return true;
    }

    public boolean deleteUserByUsername(String username) {
        User user = userDAO.findByUsername(username);
        userDAO.delete(user);
        return true;
    }

}
