package com.BetterGREwords.repository;

import com.BetterGREwords.model.WrongWordList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface WrongWordListDAO extends JpaRepository<WrongWordList, Long> {
    @Query("SELECT MAX(w.wrongWordListId) FROM WrongWordList w")
    Long findMaxWrongWordListId();

    Optional<WrongWordList> findByWrongWordIdAndWrongUserId(Long wrongWordId, Long wrongUserId);

    @Modifying
    @Transactional
    @Query("UPDATE WrongWordList u SET u.wrongTimes = u.wrongTimes + 1 WHERE u.Id = :Id")
    int updateWrongTImes(@Param("Id") Long Id);
}
