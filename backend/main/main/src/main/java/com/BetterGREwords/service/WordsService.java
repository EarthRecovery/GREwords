package com.BetterGREwords.service;

import com.BetterGREwords.model.Words;
import com.BetterGREwords.repository.WordsDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordsService {

    private final WordsDAO wordsDAO;

    public WordsService(WordsDAO wordsDAO) {
        this.wordsDAO = wordsDAO;
    }

    /**
     * get Word info by its id
     */
    public Words getWordById(long wordId) {
        Words w = wordsDAO.findById(wordId).orElse(null);
        if(w == null) {
            throw new IllegalArgumentException("Word with id " + wordId + " does not exist");
        }
        return w;
    }

    /**
     * get Words info by many words id
     */
    public List<Words> getWordsById(List<Long> wordIds) {
        return wordsDAO.findAllById(wordIds);
    }
}
