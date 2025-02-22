package com.BetterGREwords.service;

import com.BetterGREwords.repository.WrongWordListDAO;
import org.springframework.stereotype.Service;

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
}
