package com.example.Verlynkblogapplication.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.time.LocalDateTime;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

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

    private LocalDateTime updatedAt;

    @NonNull
    @ManyToOne
    @JoinColumn(name ="account_id", referencedColumnName = "id",nullable = false)
    private Account account;

    @Override
    public String toString(){
        return "Post{" +
                "id=" + id +
                ",title='" + title + "'" +
                ",body='" + body + "'" +
                ",createdAt='" + createdAt + "'" +
                ",updateAt='" + updatedAt + "'" +
                "}";

    }
}
