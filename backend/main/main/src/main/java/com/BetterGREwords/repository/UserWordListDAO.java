package com.BetterGREwords.repository;

import com.BetterGREwords.model.UserWordList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserWordListDAO extends JpaRepository<UserWordList, Long> {
    @Query("SELECT MAX(w.wrongWordListId) FROM UserWordList w")
    Long findMaxWrongWordListId();

    @Query("SELECT MAX(w.userWordProgressId) FROM UserWordList w")
    Long findMaxUserWordProgressId();
}
