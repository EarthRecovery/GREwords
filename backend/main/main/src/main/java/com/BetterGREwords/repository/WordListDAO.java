package com.BetterGREwords.repository;

import com.BetterGREwords.model.WordList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WordListDAO extends JpaRepository<WordList, Long> {
    @Query("SELECT w FROM WordList w WHERE w.wordListId = :wordListId")
    List<WordList> findByWordListId(Long wordListId);
}
