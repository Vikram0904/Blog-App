package com.example.Verlynkblogapplication.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long Id;

    private  String title;

    @Column(columnDefinition = "Text")
    private String body;

    private LocalDateTime createdAt;

    @NonNull
    @ManyToOne
    @JoinColumn(name ="account_id", referencedColumnName = "id",nullable = false)
    private Account account;
}
