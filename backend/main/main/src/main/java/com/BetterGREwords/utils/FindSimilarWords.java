package com.BetterGREwords.utils;

import com.BetterGREwords.model.Words;
import com.BetterGREwords.repository.WordsDAO;
import com.BetterGREwords.service.WordListService;
import org.apache.commons.math3.util.Pair;
import org.apache.commons.text.similarity.LevenshteinDistance;
import org.springframework.stereotype.Service;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FindSimilarWords {

    private final WordListService wordListService;
    private List<Words> wordsList;
    private List<Pair<String,Long>> wordsStringList;
    private final WordsDAO wordsDAO;

    public FindSimilarWords(WordListService wordListService, WordsDAO wordsDAO) {
        this.wordListService = wordListService;
        this.wordsDAO = wordsDAO;
    }

    public List<Pair<String,Long>> findSimilarWords(String word){
        LevenshteinDistance levenshtein = new LevenshteinDistance();

        return wordsStringList.stream()
                // 计算 Levenshtein 距离，并存入 Entry
                .map(pair -> new AbstractMap.SimpleEntry<>(pair, levenshtein.apply(word, pair.getFirst())))
                // 按距离排序
                .sorted((p1, p2) -> Integer.compare(p1.getValue(), p2.getValue()))
                // 取前 4 个
                .limit(4)
                // 移除距离信息
                .map(entry -> new Pair<>(entry.getKey().getFirst(), entry.getKey().getSecond()))
                .collect(Collectors.toList());
    }

    public void run(){
        wordsList = wordListService.getWordsByWordListId(1);
        wordsStringList = new ArrayList<>();
        for(Words w : wordsList){
            wordsStringList.add(new Pair<>(w.getWordName(), w.getId()));
        }

        for(Words w : wordsList){
            List<Pair<String,Long>> similarWords = findSimilarWords(w.getWordName());
            wordsDAO.updateSimilarWords(w.getId(), similarWords.get(0).getSecond(),
                    similarWords.get(1).getSecond(), similarWords.get(2).getSecond(),
                    similarWords.get(3).getSecond());
        }
    }
}
