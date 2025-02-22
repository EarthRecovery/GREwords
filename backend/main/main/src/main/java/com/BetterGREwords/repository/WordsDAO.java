package com.BetterGREwords.repository;

import com.BetterGREwords.model.Words;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WordsDAO extends JpaRepository<Words, Long> {
}

