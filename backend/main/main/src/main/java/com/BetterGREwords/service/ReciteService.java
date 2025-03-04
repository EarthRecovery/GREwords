package com.BetterGREwords.service;

import com.BetterGREwords.model.UserWordList;
import com.BetterGREwords.model.Words;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReciteService {

    private final UserWordProgressService userWordProgressService;
    private final UserWordListService userWordListService;
    private final WordsService wordsService;
    private final WrongWordListService wrongWordListService;

    public ReciteService(UserWordProgressService userWordProgressService, UserWordListService userWordListService,
                         WordsService wordsService, WrongWordListService wrongWordListService) {
        this.userWordProgressService = userWordProgressService;
        this.userWordListService = userWordListService;
        this.wordsService = wordsService;
        this.wrongWordListService = wrongWordListService;
    }

    /**
     * get 10 Words (0 review times) for recite by user_word_progress_id
     */
    public List<Words> getReciteWords(long userWordProgressId) {
        List<Long> wordIds = userWordProgressService.generateRandomWordIdsWithZeroReviewTimes(userWordProgressId, 10);
        List<Words> words = wordsService.getWordsById(wordIds);
        return words;
    }

    /**
     * design controller when recite a word and answer wrong
     */
    public void wrongWord(long userWordListId, long wordId) {
        UserWordList userWordList = userWordListService.getUserWordListById(userWordListId);
        long wrongWordListId = userWordList.getWrongWordListId();
        long wordListUserId = userWordList.getWordListUserId();
        long userWordProgressId = userWordList.getUserWordProgressId();

        // add the word to wrong word list
        wrongWordListService.addWordToWrongWordList(wrongWordListId, wordId, wordListUserId);

        // add the record to the user word progress
        userWordProgressService.increaseReviewCount(userWordProgressId, wordId);
    }

    /**
     * design controller when recite a word and answer right
     */
    public void rightWord(long userWordListId, long wordId) {
        UserWordList userWordList = userWordListService.getUserWordListById(userWordListId);
        long userWordProgressId = userWordList.getUserWordProgressId();

        // add the record to the user word progress
        userWordProgressService.increaseReviewCount(userWordProgressId, wordId);
        userWordProgressService.increaseCorrectCount(userWordProgressId, wordId);
    }


}
