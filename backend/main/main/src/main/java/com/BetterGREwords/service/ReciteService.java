package com.BetterGREwords.service;

import com.BetterGREwords.model.Words;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReciteService {

    private final UserWordProgressService userWordProgressService;
    private final UserWordListService userWordListService;
    private final WordsService wordsService;

    public ReciteService(UserWordProgressService userWordProgressService, UserWordListService userWordListService, WordsService wordsService) {
        this.userWordProgressService = userWordProgressService;
        this.userWordListService = userWordListService;
        this.wordsService = wordsService;
    }

    /**
     * get 10 Words (0 review times) for recite by user_word_progress_id
     */
    public List<Words> getReciteWords(long userWordProgressId) {
        List<Long> wordIds = userWordProgressService.generateRandomWordIdsWithZeroReviewTimes(userWordProgressId, 10);
        List<Words> words = wordsService.getWordsById(wordIds);
        return words;
    }
}
