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

    @Column(nullable = false, name = "word_name")
    private String wordName;

    @Column(nullable = false, name = "chinese_name")
    private String chineseName;

    @Column(nullable = true, name = "example_sentence_1")
    private String exampleSentence1;

    @Column(nullable = true, name = "example_sentence_1_chinese")
    private String exampleSentence1Chinese;

    @Column(nullable = true, name = "example_sentence_2")
    private String exampleSentence2;

    @Column(nullable = true, name = "example_sentence_2_chinese")
    private String exampleSentence2Chinese;

    @Column(nullable = false, name = "url")
    private String url;

    @Column(nullable = false, name = "similar_word_1")
    private Long similarWord1;

    @Column(nullable = false, name = "similar_word_2")
    private Long similarWord2;

    @Column(nullable = false, name = "similar_word_3")
    private Long similarWord3;

    @Column(nullable = false, name = "similar_word_4")
    private Long similarWord4;

}
