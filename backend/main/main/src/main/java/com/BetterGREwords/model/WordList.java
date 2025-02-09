package com.BetterGREwords.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "word_list")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WordList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int word_list_id;

    @Column(nullable = false)
    private String word_list_name;

    @Column(nullable = false)
    private int word_id;
}
