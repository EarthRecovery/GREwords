package com.BetterGREwords.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "wrong_word_list")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WrongWordList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int wrong_word_list_id;

    @Column(nullable = false)
    private Date wrong_time;

    @Column(nullable = false)
    private int wrong_word_id;
}
