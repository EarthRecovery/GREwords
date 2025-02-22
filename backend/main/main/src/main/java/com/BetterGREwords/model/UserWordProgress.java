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

    @Column(nullable = false, name = "user_word_progress_id")
    private Long userWordProgressId;

    @Column(nullable = false, name = "word_id")
    private Long wordId;

    @Column(nullable = true, name = "correct_times")
    private int correctTimes;

    @Column(nullable = true, name = "review_times")
    private int reviewTimes;

    public UserWordProgress(Long userWordProgressId, Long wordId) {
        this.userWordProgressId = userWordProgressId;
        this.wordId = wordId;
        this.correctTimes = 0;
        this.reviewTimes = 0;
    }
}
