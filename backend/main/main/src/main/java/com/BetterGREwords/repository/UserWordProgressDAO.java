package com.BetterGREwords.repository;

import com.BetterGREwords.model.UserWordProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserWordProgressDAO extends JpaRepository<UserWordProgress, Long> {
    @Query("SELECT MAX(w.userWordProgressId) FROM UserWordProgress w")
    Long findMaxWrongWordListId();

    @Modifying
    @Transactional
    @Query("UPDATE UserWordProgress u SET u.correctTimes = u.correctTimes + 1 WHERE u.userWordProgressId = :userWordProgressId AND u.wordId = :wordId")
    int updateCorrectCount(@Param("userWordProgressId") Long userWordProgressId, @Param("wordId") Long wordId);

    @Modifying
    @Transactional
    @Query("UPDATE UserWordProgress u SET u.reviewTimes = u.reviewTimes + 1 WHERE u.userWordProgressId = :userWordProgressId AND u.wordId = :wordId")
    int updateReviewCount(@Param("userWordProgressId") Long userWordProgressId, @Param("wordId") Long wordId);

    @Query("SELECT u.wordId FROM UserWordProgress u WHERE u.reviewTimes = 0 AND u.userWordProgressId = :userWordProgressId")
    List<Long> findWordIdsWithZeroReviewTimes(@Param("userWordProgressId") Long userWordProgressId);
}
