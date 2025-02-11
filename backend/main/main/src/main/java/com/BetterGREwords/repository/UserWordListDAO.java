package com.BetterGREwords.repository;

import com.BetterGREwords.model.UserWordList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserWordListDAO extends JpaRepository<UserWordList, Long> {
    List<UserWordList> findByWordListUserId(int word_list_user_id);
    List<UserWordList> findByWordListId(int word_list_id);
    UserWordList findByWordListUserIdAndWordListId(int word_list_user_id, int word_list_id);
    void deleteByWordListUserIdAndWordListId(int word_list_user_id, int word_list_id);
    void deleteByWordListUserId(int word_list_user_id);
    void deleteByWordListId(int word_list_id);
}
