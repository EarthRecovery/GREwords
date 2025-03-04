package com.BetterGREwords.controller;

import com.BetterGREwords.model.Words;
import com.BetterGREwords.service.ReciteService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recite")
public class ReciteController {

    private final ReciteService reciteService;

    @Autowired
    public ReciteController(ReciteService reciteService) {
        this.reciteService = reciteService;
    }

    @GetMapping("/get10RandomWords/{userWordProgressId}")
    public ResponseEntity<List<Words>> getReciteWords(@PathVariable("userWordProgressId") long userWordProgressId) {
        List<Words> words = reciteService.getReciteWords(userWordProgressId);
        if(words.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(words);
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(words);
        }
    }

    /**
     * design controller when recite a word
     */

    /**
     * if user regret the word, update wrong word list and user word progress
     */

    @PostMapping("wrongWord")
    public ResponseEntity<?> wrongWord(@RequestParam long userWordListId, @RequestParam long wordId){
        reciteService.wrongWord(userWordListId, wordId);
        return ResponseEntity.status(HttpStatus.OK).body("success");
    }

    /**
     * if user remember the word, update user word progress
     */
    @PostMapping("rightWord")
    public ResponseEntity<?> rightWord(@RequestParam long userWordListId, @RequestParam long wordId){
        reciteService.rightWord(userWordListId, wordId);
        return ResponseEntity.status(HttpStatus.OK).body("success");
    }
}
