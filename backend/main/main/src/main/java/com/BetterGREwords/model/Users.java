package com.BetterGREwords.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
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

    @Column(nullable = true)
    private String email;

    @Column(nullable = false, name = "password_hash")  // 让数据库字段与 Java 字段映射
    private String passwordHash;

    @Column(nullable = false, name = "created_time", updatable = false)
    private LocalDateTime createdTime;

    @Column(nullable = true, name = "favourite_table_user_id")
    private Integer favouriteTableUserId;

    @Column(nullable = true, name = "word_list_user_id")
    private Integer wordListUserId;

    @PrePersist
    protected void onCreate() {
        this.createdTime = LocalDateTime.now();
    }
}
