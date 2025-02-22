package com.BetterGREwords.repository;

import com.BetterGREwords.model.WrongWordList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WrongWordListDAO extends JpaRepository<WrongWordList, Long> {
    @Query("SELECT MAX(w.wrongWordListId) FROM WrongWordList w")
    Long findMaxWrongWordListId();
}
