package com.BetterGREwords.service;

import com.BetterGREwords.model.Words;
import com.BetterGREwords.repository.WordsDAO;
import org.springframework.stereotype.Service;

@Service
public class WordsService {

    private final WordsDAO wordsDAO;

    public WordsService(WordsDAO wordsDAO) {
        this.wordsDAO = wordsDAO;
    }

    /**
     * Add a word to the database
     * @param word the word to add
     * @return true if the word was added successfully
     */
    public boolean Add_a_word(Words word) {
        if(word == null) {
            System.out.println("Word is null");
            return false;
        }
        if(word.getId() != null){
            System.out.println("word Input has a Id");
        }
        try {
            wordsDAO.save(word);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * get a word by its id
     * @param word_id the id of the word
     * @return the word with the given id, if it does not exist return null
     */
    public Words getWordById(int word_id) {
        try {
            return wordsDAO.findByWordId(word_id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * get a word by its word
     * @param word the word
     * @return the word with the given word, if it does not exist return null
     */
    public Words getWordByWord(String word) {
        try {
            return wordsDAO.findByWord(word);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * delete a word by its id
     * @param word_id the id of the word
     * @return true if the word was deleted successfully
     */
    public boolean deleteWordById(int word_id) {
        try {
            wordsDAO.deleteByWordId(word_id);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * delete a word by its word
     * @param word the word
     * @return true if the word was deleted successfully
     */
    public boolean deleteWordByWord(String word) {
        try {
            wordsDAO.deleteByWord(word);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
