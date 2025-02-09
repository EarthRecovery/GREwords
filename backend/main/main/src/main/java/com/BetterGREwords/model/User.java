package com.BetterGREwords.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column()
    private String email;

    @Column(nullable = false)
    private String password_hash;

    @Temporal(TemporalType.TIMESTAMP)
    @Column()
    private Date created_time;

    @Column()
    private int favourite_table_user_id;

    @Column()
    private int word_list_user_id;

    public User(String username, String email, String password_hash) {
        this.username = username;
        this.email = email;
        this.password_hash = password_hash;
        this.created_time = null;
        this.favourite_table_user_id = -1;
        this.word_list_user_id = -1;
    }
}
