package com.BetterGREwords.service;

import com.BetterGREwords.model.WordList;
import com.BetterGREwords.repository.WordListDAO;
import org.springframework.stereotype.Service;

@Service
public class WordListService {

    private final WordListDAO wordListDAO;

    public WordListService(WordListDAO wordListDAO) {
        this.wordListDAO = wordListDAO;
    }

    /**
     * create a new wordList
     */
    public WordList createWordList(WordList wordList){
        return this.wordListDAO.save(wordList);
    }

    /**
     * create a new wordList by wordlist id, word id and name
     */
    public WordList createWordList(long wordListId, long wordId, String name){
        return this.wordListDAO.save(new WordList(null, wordListId, name, wordId));
    }
}
