package com.BetterGREwords.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
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

    @Column(nullable = false, name = "wrong_word_list_id")
    private Long wrongWordListId;

    @Column(nullable = false, name = "wrong_time")
    private LocalDateTime wrongTime;

    @Column(nullable = false, name = "wrong_word_id")
    private Long wrongWordId;

    @Column(nullable = false, name = "wrong_times")
    private int wrongTimes;

    @Column(nullable = false, name = "wrong_user_id")
    private Long wrongUserId;

    public WrongWordList(Long wrongWordId, Long wrongUserId, int wrongTimes, Long wrongWordListId) {
        this.wrongWordId = wrongWordId;
        this.wrongUserId = wrongUserId;
        this.wrongTimes = wrongTimes;
        this.wrongWordListId = wrongWordListId;
        this.wrongTime = LocalDateTime.now();
    }
}

