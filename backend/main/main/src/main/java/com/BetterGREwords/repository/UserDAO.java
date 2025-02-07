package com.BetterGREwords.repository;

import com.BetterGREwords.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {
    User findByUsername(String username);  // find User Entity based on the Username
    User findByEmail(String email);  // find User Entity based on the Email
}
