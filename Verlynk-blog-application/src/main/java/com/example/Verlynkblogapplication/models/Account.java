package com.example.Verlynkblogapplication.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String password;

    private String firstName;

    private String lastName;

    private String Email;

    @OneToMany(mappedBy ="account")
    private List<Post> posts;

}
