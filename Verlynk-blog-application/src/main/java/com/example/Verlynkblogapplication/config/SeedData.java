package com.example.Verlynkblogapplication.config;


import com.example.Verlynkblogapplication.models.Account;
import com.example.Verlynkblogapplication.models.Authority;
import com.example.Verlynkblogapplication.models.Post;
import com.example.Verlynkblogapplication.repository.AuthorityRepository;
import com.example.Verlynkblogapplication.services.AccountService;
import com.example.Verlynkblogapplication.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class SeedData implements CommandLineRunner {
  @Autowired
  private PostService postService;

  @Autowired
  private AccountService accountService;

  @Autowired
  private AuthorityRepository authorityRepository;

    @Override
    public void run(String... args) throws Exception {
        List<Post> posts = postService.getAll();

        if(posts.size() == 0){

            Authority user = new Authority();
            user.setName("ROLE_USER");
            authorityRepository.save(user);

            Authority admin = new Authority();
            admin.setName("ROLE_ADMIN");
            authorityRepository.save(admin);

            Account account1 = new Account();
            Account account2 = new Account();

            account1.setFirstName("Vikram");
            account1.setLastName("Surya");
            account1.setEmail("vik466@gmail.com");
            account1.setPassword("vik");
            Set<Authority> authorities1 = new HashSet<>();
            authorityRepository.findById("ROLE_USER").ifPresent(authorities1::add);
            account1.setAuthorities(authorities1);


            account2.setFirstName("Sathish");
            account2.setLastName("Kumar");
            account2.setEmail("sat452@gmail.com");
            account2.setPassword("sat");
            Set<Authority> authorities2 = new HashSet<>();
            authorityRepository.findById("ROLE_USER").ifPresent(authorities2::add);
            authorityRepository.findById("ROLE_ADMIN").ifPresent(authorities2::add);
            account2.setAuthorities(authorities2);

            accountService.save(account1);
            accountService.save(account2);


            Post post1 = new Post();
            post1.setTitle("Secondhand Time");
            post1.setBody("The Belarusian Nobel laureate recorded thousands of hours of testimony from ordinary people to create this oral history of the Soviet Union and its end. Writers, waiters, doctors, soldiers, former Kremlin apparatchiks, gulag survivors: all are given space to tell their stories, share their anger and betrayal, and voice their worries about the transition to capitalism. An unforgettable book, which is both an act of catharsis and a profound demonstration of empathy.");
            post1.setAccount(account1);

            Post post2 = new Post();
            post2.setTitle("My Brilliant Friend");
            post2.setBody("Powerfully intimate and unashamedly domestic, the first in Ferrante’s Neapolitan series established her as a literary sensation. This and the three novels that followed documented the ways misogyny and violence could determine lives, as well as the history of Italy in the late 20th century.");
            post2.setAccount(account2);

            postService.save(post1);
            postService.save(post2);

        }
    }
}
