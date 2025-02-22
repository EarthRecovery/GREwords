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

    @Column(nullable = false, name = "word_list_id")
    private Long wordListId;

    @Column(nullable = false, name = "word_list_name")
    private String wordListName;

    @Column(nullable = false, name = "word_id")
    private Long wordId;
}
