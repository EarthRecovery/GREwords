package com.BetterGREwords.repository;

import com.BetterGREwords.model.FavouriteTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavouriteTableDAO extends JpaRepository<FavouriteTable, Long> {
    List<FavouriteTable> findByFavouriteTableUserId(int favourite_table_user_id);
    List<FavouriteTable> findByFavouriteWordId(int favourite_word_id);
    FavouriteTable findByFavouriteTableUserIdAndFavouriteWordId(int favourite_table_user_id, int favourite_word_id);
    void deleteByFavouriteTableUserIdAndFavouriteWordId(int favourite_table_user_id, int favourite_word_id);
    void deleteByFavouriteTableUserId(int favourite_table_user_id);
    void deleteByFavouriteWordId(int favourite_word_id);
}
