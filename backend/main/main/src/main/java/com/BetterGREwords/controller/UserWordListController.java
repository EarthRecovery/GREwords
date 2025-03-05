package com.BetterGREwords.controller;

import com.BetterGREwords.service.UserWordListService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/userWordList")
public class UserWordListController {

    private final UserWordListService userWordListService;

    public UserWordListController(UserWordListService userWordListService) {
        this.userWordListService = userWordListService;
    }

    /**
     * create a user word service for a user and a word list
     */
    @PostMapping("/create")
    public void createUserWordList(@RequestParam  long userId, @RequestParam long wordListId) {
        userWordListService.createUserWordList(userId, wordListId);
    }
}
