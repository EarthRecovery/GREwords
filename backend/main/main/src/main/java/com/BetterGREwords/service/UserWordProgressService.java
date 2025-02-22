package com.BetterGREwords.service;

import com.BetterGREwords.model.UserWordProgress;
import com.BetterGREwords.model.WordList;
import com.BetterGREwords.repository.UserWordProgressDAO;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
public class UserWordProgressService {

    private final UserWordProgressDAO userWordProgressDAO;
    private final WordListService wordListService;

    public UserWordProgressService(UserWordProgressDAO userWordProgressDAO, WordListService wordListService) {
        this.userWordProgressDAO = userWordProgressDAO;
        this.wordListService = wordListService;
    }

    /**
     * get max user_word_progress_id
     */
    public Long findMaxWrongWordListId() {
        return userWordProgressDAO.findMaxWrongWordListId();
    }

    /**
     * create a default word progress history by user_word_progress_id and user word list id
     */
    public void createDefaultWordProgressHistory(long user_word_progress_id, long wordListId) {
        List<WordList> wordList = wordListService.getWordListById(wordListId);
        for(WordList wl : wordList) {
            UserWordProgress userWordProgress = new UserWordProgress(user_word_progress_id, wl.getWordId());
            userWordProgressDAO.save(userWordProgress);
        }
    }

    /**
     * increase correct count by user_word_progress_id and word_id
     */
    public void increaseCorrectCount(long user_word_progress_id, long word_id) {
        int updatedRows = userWordProgressDAO.updateCorrectCount(user_word_progress_id, word_id);
        if(updatedRows == 0) {
            throw new RuntimeException("No row updated when increaseCorrectCount");
        }
    }

    /**
     * increase review count by user_word_progress_id and word_id
     */
    public void increaseReviewCount(long user_word_progress_id, long word_id) {
        int updatedRows = userWordProgressDAO.updateReviewCount(user_word_progress_id, word_id);
        if (updatedRows == 0) {
            throw new RuntimeException("No row updated when increaseReviewCount");
        }
    }

    /**
     * find word_id where review_count is 0 by user_word_progress_id
     */
    public List<Long> findWordIdsWithZeroReviewTimes(long user_word_progress_id) {
        List<Long> wordList = userWordProgressDAO.findWordIdsWithZeroReviewTimes(user_word_progress_id);
        if (wordList == null) {
            throw new RuntimeException("No word found when findWordIdsWithZeroReviewTimes");
        }
        return wordList;
    }

    /**
     * generate 10 random words where review_count is 0 by user_word_progress_id
     */
    public List<Long> generateRandomWordIdsWithZeroReviewTimes(long user_word_progress_id, int count) {
        List<Long> wordList = findWordIdsWithZeroReviewTimes(user_word_progress_id);
        Collections.shuffle(wordList, new Random());
        if(wordList.size() > count) {
            return wordList.subList(0, count);
        } else {
            return wordList;
        }
    }
}
