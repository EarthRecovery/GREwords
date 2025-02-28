package com.BetterGREwords.controller;

import com.BetterGREwords.model.Words;
import com.BetterGREwords.service.ReciteService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
