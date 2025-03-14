package com.BetterGREwords.repository;

import com.BetterGREwords.model.Words;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface WordsDAO extends JpaRepository<Words, Long> {

    @Modifying
    @Transactional
    @Query( "UPDATE Words w SET w.similarWord1 = :similarWord1, w.similarWord2 = :similarWord2, w.similarWord3 = :similarWord3, w.similarWord4 = :similarWord4 WHERE w.id = :wordId")
    int updateSimilarWords(@Param("wordId") Long wordId, @Param("similarWord1") Long similarWord1,
                           @Param("similarWord2") Long similarWord2, @Param("similarWord3") Long similarWord3,
                           @Param("similarWord4") Long similarWord4);

    @Modifying
    @Transactional
    @Query( "UPDATE Words w SET w.similarWord1Name = :similarWord1, w.similarWord2Name = :similarWord2, w.similarWord3Name = :similarWord3, w.similarWord4Name = :similarWord4 WHERE w.id = :wordId")
    int updateSimilarWordsName(@Param("wordId") Long wordId, @Param("similarWord1") String similarWord1,
                               @Param("similarWord2") String similarWord2, @Param("similarWord3") String similarWord3,
                               @Param("similarWord4") String similarWord4);
}

