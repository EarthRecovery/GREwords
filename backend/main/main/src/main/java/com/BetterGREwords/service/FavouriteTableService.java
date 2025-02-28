package com.BetterGREwords.service;

import com.BetterGREwords.model.FavouriteTable;
import com.BetterGREwords.repository.FavouriteTableDAO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FavouriteTableService {
    private final FavouriteTableDAO favouriteTableDAO;

    public FavouriteTableService(FavouriteTableDAO favouriteTableDAO) {
        this.favouriteTableDAO = favouriteTableDAO;
    }

    public boolean isFavouriteTablePresent(long userId){
        List<FavouriteTable> favouriteTableList = favouriteTableDAO.
                findByFavouriteTableUserId(userId).orElse(null);
        return favouriteTableList != null;
    }

    public void insertIntoFavouriteTable(long userId, long wordId){
        FavouriteTable favouriteTable = new FavouriteTable(null, userId, wordId);
        favouriteTableDAO.save(favouriteTable);
    }

    public List<Long> getFavouriteWords(long userId){
        List<FavouriteTable> favouriteTableList = favouriteTableDAO.
                findByFavouriteTableUserId(userId).orElse(null);
        if(favouriteTableList == null){
            return null;
        }
        List<Long> wordsIdList = new ArrayList<>();
        for(FavouriteTable favouriteTable: favouriteTableList){
            wordsIdList.add(favouriteTable.getFavouriteWordId());
        }
        return wordsIdList;
    }

    public boolean isWordFavourite(long userId, long wordId) {
        FavouriteTable favouriteTable = favouriteTableDAO.
                findByFavouriteTableUserIdAndFavouriteWordId(userId, wordId).orElse(null);
        return favouriteTable != null;
    }
}
