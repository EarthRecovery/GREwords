package com.BetterGREwords.repository;

import com.BetterGREwords.model.WordList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WordListDAO extends JpaRepository<WordList, Long> {

}
