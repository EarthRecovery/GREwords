package com.BetterGREwords.repository;

import com.BetterGREwords.model.WrongWordList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WrongWordListDAO extends JpaRepository<WrongWordList, Long> {

}
