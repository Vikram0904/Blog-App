package com.example.Verlynkblogapplication.models;

import jakarta.persistence.*;
import lombok.Getter;
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

}
