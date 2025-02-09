package com.BetterGREwords.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_word_list")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserWordList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int word_list_id;

    @Column(nullable = false)
    private int word_list_user_id;

    @Column(nullable = false)
    private int wrong_word_list_id;

}
