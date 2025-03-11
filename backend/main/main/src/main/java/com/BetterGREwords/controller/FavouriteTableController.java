package com.BetterGREwords.controller;

import com.BetterGREwords.model.Words;
import com.BetterGREwords.service.FavouriteTableService;
import com.BetterGREwords.service.WordsService;
import com.BetterGREwords.utils.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favourite")
public class FavouriteTableController {

    private final FavouriteTableService favouriteTableService;
    private final WordsService wordsService;

    @Autowired
    public FavouriteTableController(FavouriteTableService favouriteTableService, WordsService wordsService) {
        this.favouriteTableService = favouriteTableService;
        this.wordsService = wordsService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllFavouriteWordsByUserId(@RequestParam Long userId){
        if(userId == null){
            ErrorResponse errorResponse = new ErrorResponse("userId is null", HttpStatus.BAD_REQUEST.value());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
        List<Long> wordIds = favouriteTableService.getFavouriteWords(userId);
        if(wordIds == null){
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
        List<Words> words = wordsService.getWordsById(wordIds);
        return ResponseEntity.status(HttpStatus.OK).body(words);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addFavouriteWord(@RequestParam long userId, @RequestParam long wordId){
        if(favouriteTableService.isWordFavourite(userId, wordId)){
            ErrorResponse errorResponse = new ErrorResponse("word is already in favourite list",HttpStatus.BAD_REQUEST.value());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
        favouriteTableService.insertIntoFavouriteTable(userId, wordId);
        return ResponseEntity.status(HttpStatus.OK).body("success");
    }
}
