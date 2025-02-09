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

    @Column(nullable = false)
    private int favourite_table_user_id;

    @Column(nullable = false)
    private int favourite_word_id;
}
