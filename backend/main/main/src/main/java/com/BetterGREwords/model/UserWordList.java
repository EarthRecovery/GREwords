package com.BetterGREwords.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @Column(nullable = false)
    private Long word_list_id;

    @Column(nullable = false)
    private Long word_list_user_id;

    @Column(nullable = false)
    private Long wrong_word_list_id;

    @Column(nullable = false)
    private Long user_word_progress_id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date created_at;

}
