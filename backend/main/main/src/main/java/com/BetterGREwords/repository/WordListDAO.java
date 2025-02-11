package com.BetterGREwords.repository;

import com.BetterGREwords.model.WordList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WordListDAO extends JpaRepository<WordList, Long> {
    List<WordList> findByWordListId(int word_list_id);
    void deleteByWordListId(int word_list_id);
}
