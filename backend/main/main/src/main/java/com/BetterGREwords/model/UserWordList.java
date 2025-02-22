package com.BetterGREwords.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

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

    @Column(nullable = false, name = "word_list_id")
    private Long wordListId;

    @Column(nullable = false, name = "word_list_user_id")
    private Long wordListUserId;

    @Column(nullable = false, name = "wrong_word_list_id")
    private Long wrongWordListId;

    @Column(nullable = false, name = "user_word_progress_id")
    private Long userWordProgressId;

    @Column(nullable = false, name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    public UserWordList(Long wordListId, Long wordListUserId, Long wrongWordListId, Long userWordProgressId) {
        this.wordListId = wordListId;
        this.wordListUserId = wordListUserId;
        this.wrongWordListId = wrongWordListId;
        this.userWordProgressId = userWordProgressId;
        this.createdAt = LocalDateTime.now();
    }
}
