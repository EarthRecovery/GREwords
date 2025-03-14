package com.BetterGREwords.controller;

import com.BetterGREwords.model.WordListOutput;
import com.BetterGREwords.service.WordListService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/wordList")
public class WordListController {
    private final WordListService wordListService;

    public WordListController(WordListService wordListService) {
        this.wordListService = wordListService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllWordList() {
        List<WordListOutput> wordList = wordListService.getAllwordLists();
        return ResponseEntity.ok(wordList);
    }
}
