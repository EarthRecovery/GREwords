package com.BetterGREwords.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "words")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Words {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String word_name;

    @Column(nullable = false)
    private String chinese_name;

    @Column(nullable = false)
    private String example_sentence_1;

    @Column(nullable = false)
    private String example_sentence_1_chinese;

    @Column(nullable = false)
    private String example_sentence_2;

    @Column(nullable = false)
    private String example_sentence_2_chinese;

    @Column(nullable = false)
    private String url;

}
