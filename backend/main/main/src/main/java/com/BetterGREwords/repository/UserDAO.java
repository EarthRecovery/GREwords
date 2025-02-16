package com.BetterGREwords.repository;

import com.BetterGREwords.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<Users, Long> {

}
