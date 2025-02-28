package com.BetterGREwords.repository;

import com.BetterGREwords.model.FavouriteTable;
import org.apache.poi.sl.draw.geom.GuideIf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FavouriteTableDAO extends JpaRepository<FavouriteTable, Long> {
    Optional<List<FavouriteTable>> findByFavouriteTableUserId(Long userId);
    Optional<FavouriteTable> findByFavouriteTableUserIdAndFavouriteWordId(Long userId, Long wordId);
}
