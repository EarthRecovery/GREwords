package com.BetterGREwords.repository;

import com.BetterGREwords.model.Words;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WordsDAO extends JpaRepository<Words, Long> {
    Words findByWordId(int word_id);
    Words findByWord(String word);
    void deleteByWordId(int word_id);
    void deleteByWord(String word);
}
