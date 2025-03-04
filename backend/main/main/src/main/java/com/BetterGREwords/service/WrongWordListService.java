package com.BetterGREwords.service;

import com.BetterGREwords.model.WrongWordList;
import com.BetterGREwords.repository.WrongWordListDAO;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WrongWordListService {

    private final WrongWordListDAO wrongWordListDAO;

    public WrongWordListService(WrongWordListDAO wrongWordListDAO) {
        this.wrongWordListDAO = wrongWordListDAO;
    }

    /**
     * get max wrong word list id
     */
    public Long getMaxWrongWordListId() {
        return wrongWordListDAO.findMaxWrongWordListId();
    }

    /**
     * add a word to wrong word list
     */

    public void addWordToWrongWordList(long wrongWordListId, long wordId, long userId) {
        WrongWordList wrongWordList = wrongWordListDAO.findByWrongWordIdAndWrongUserId(wordId, userId).orElse(null);
        if(wrongWordList == null) {
            wrongWordListDAO.save(new WrongWordList(wordId, userId,1, wrongWordListId));
        }else{
            wrongWordListDAO.updateWrongTImes(wrongWordList.getId());
        }
    }
}
