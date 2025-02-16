package com.BetterGREwords.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_word_progress")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserWordProgress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long user_word_list_id;

    @Column(nullable = false)
    private Long word_id;

    @Column(nullable = true)
    private int correct_times;

    @Column(nullable = true)
    private int review_times;

    public UserWordProgress(Long user_word_list_id, Long word_id){
        this.id = null;
        this.user_word_list_id = user_word_list_id;
        this.word_id = word_id;
        this.correct_times = 0;
        this.review_times = 0;
    }
}
