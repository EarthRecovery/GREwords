package com.BetterGREwords.service;

import com.BetterGREwords.model.WordList;
import com.BetterGREwords.model.WordListOutput;
import com.BetterGREwords.model.Words;
import com.BetterGREwords.repository.WordListDAO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WordListService {

    private final WordListDAO wordListDAO;
    private final WordsService wordsService;

    public WordListService(WordListDAO wordListDAO, WordsService wordsService) {
        this.wordListDAO = wordListDAO;
        this.wordsService = wordsService;
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
            return wordListDAO.findByWordListId(wordListId).orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * find all words in the wordList by word list id
     */
    public List<Words> getWordsByWordListId(long wordListId) {
        List<WordList> wordLists = wordListDAO.findByWordListId(wordListId).orElse(null);
        if(wordLists.isEmpty()){
            return null;
        }
        List<Words> words = new ArrayList<>();
        for(WordList wordList : wordLists){
            Long wordId = wordList.getWordId();
            Words word = wordsService.getWordById(wordId);
            words.add(word);
        }
        return words;
    }

    /**
     * get name of the wordList by word list id
     */
    public String getNameByWordListId(long wordListId) {
        List<WordList> wordLists = wordListDAO.findByWordListId(wordListId).orElse(null);
        if (wordLists == null) {
            return null;
        }
        return wordLists.get(0).getWordListName();
    }

    /**
     * get all wordLists
     */
    public List<WordListOutput> getAllwordLists(){
        List<WordListOutput> wordListOutputs = new ArrayList<>();
        int i=1;
        while(true){
            List<Words> wL = getWordsByWordListId(i);
            if(wL == null){
                return wordListOutputs;
            }
            String name = getNameByWordListId(i);
            wordListOutputs.add(new WordListOutput(name, wL));
            i++;
        }
    }
}
