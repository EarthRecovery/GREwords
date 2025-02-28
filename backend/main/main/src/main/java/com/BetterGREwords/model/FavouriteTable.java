package com.BetterGREwords.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "favourite_table")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FavouriteTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "favourite_table_user_id")  // 映射数据库字段
    private Long favouriteTableUserId;

    @Column(nullable = false, name = "favourite_word_id")  // 映射数据库字段
    private Long favouriteWordId;
}
