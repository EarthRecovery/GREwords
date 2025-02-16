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
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column()
    private String email;

    @Column(nullable = false)
    private String password_hash;

    @Temporal(TemporalType.TIMESTAMP)
    @Column()
    private Date created_time;

    @Column()
    private Integer favourite_table_user_id;

    @Column()
    private Integer word_list_user_id;

    @PrePersist
    protected void onCreate() {
        this.created_time = new Date();
    }

}
