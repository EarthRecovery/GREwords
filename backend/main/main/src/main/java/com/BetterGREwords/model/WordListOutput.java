package com.BetterGREwords.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class WordListOutput {

    private String name;
    private List<WordsOutputForWordList> wordList;

    public WordListOutput(String name, List<Words> wordList) {
        this.name = name;
        this.wordList = new ArrayList<WordsOutputForWordList>();

        for(Words word : wordList) {
            this.wordList.add(new WordsOutputForWordList(word.getId(), word.getWordName(), word.getChineseName()));
        }
    }
}

@Getter
@Setter
class WordsOutputForWordList {
    private Long id;
    private String word;
    private String meaning;

    public WordsOutputForWordList(Long id, String word, String meaning) {
        this.id = id;
        this.word = word;
        this.meaning = meaning;
    }
}
