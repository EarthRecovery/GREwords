package com.BetterGREwords.service;

import com.BetterGREwords.model.UserWordList;
import com.BetterGREwords.repository.UserWordListDAO;
import org.springframework.stereotype.Service;

@Service
public class UserWordListService {

    private final UserWordListDAO userWordListDAO;
    private final UserWordProgressService userWordProgressService;


    public UserWordListService(UserWordListDAO userWordListDAO, UserWordProgressService userWordProgressService) {
        this.userWordListDAO = userWordListDAO;
        this.userWordProgressService = userWordProgressService;
    }

    /**
     * create a new userWordList for user and create UserWordProgress and WrongWordList for that Word List
     * this will create a new UserWordList for the user and create all history of UserWordProgress for each word in the wordList
     */

    public void createUserWordList(long userId, long wordListId){
        // create a new UserWordList

        Long maxWrongWordListId = userWordListDAO.findMaxWrongWordListId();
        if(maxWrongWordListId == null){
            maxWrongWordListId = 0L;
        }
        Long maxUserWordProgressId = userWordListDAO.findMaxUserWordProgressId();
        if(maxUserWordProgressId == null){
            maxUserWordProgressId = 0L;
        }
        UserWordList userWordList = new UserWordList(wordListId,userId, maxUserWordProgressId + 1, maxWrongWordListId + 1);
        userWordListDAO.save(userWordList);
        // create a new UserWordProgress for each word in the wordList
//        userWordProgressService.createDefaultWordProgressHistory(maxUserWordProgressId + 1, wordListId);

    }
}
