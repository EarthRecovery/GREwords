package com.BetterGREwords.service;

import com.BetterGREwords.model.Users;
import com.BetterGREwords.repository.UserDAO;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    /**
     * Add a new user by instance
     */
    public Users createUser(Users user){
        return userDAO.save(user);
    }

    /**
     * Add a new user by properties
     */
    public Users createUser(String name, String password_hash, String email){
        Users user = new Users(null, name, email, password_hash, null, null, null);
        return userDAO.save(user);
    }


}
