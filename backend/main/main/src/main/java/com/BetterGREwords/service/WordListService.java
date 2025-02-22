package com.BetterGREwords.service;

import com.BetterGREwords.model.WordList;
import com.BetterGREwords.repository.WordListDAO;
import org.springframework.stereotype.Service;

import java.util.List;

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

    /**
     * get a wordList by its id
     * @param wordListId the id of the wordList
     * @return the wordList with the given id, if it does not exist return null
     */
    public List<WordList> getWordListById(long wordListId) {
        try {
            return wordListDAO.findByWordListId(wordListId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
