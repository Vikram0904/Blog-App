package com.example.Verlynkblogapplication.config;


import com.example.Verlynkblogapplication.models.Account;
import com.example.Verlynkblogapplication.models.Post;
import com.example.Verlynkblogapplication.services.AccountService;
import com.example.Verlynkblogapplication.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SeedData implements CommandLineRunner {
  @Autowired
  private PostService postService;

  @Autowired
  private AccountService accountService;

    @Override
    public void run(String... args) throws Exception {
        List<Post> posts = postService.getAll();

        if(posts.size() == 0){

            Account account1 = new Account();
            Account account2 = new Account();

            account1.setFirstName("Vikram");
            account1.setLastName("Surya");
            account1.setEmail("vik466@gmail.com");
            account1.setPassword("vik");

            account2.setFirstName("Sathish");
            account2.setLastName("Kumar");
            account2.setEmail("sat452@gmail.com");
            account2.setPassword("sat");

            accountService.save(account1);
            accountService.save(account2);


            Post post1 = new Post();
            post1.setTitle("title of post 1");
            post1.setBody("This is the body of post 1");
            post1.setAccount(account1);

            Post post2 = new Post();
            post2.setTitle("title of post 2");
            post2.setBody("This is the body of post 2");
            post2.setAccount(account2);

            postService.save(post1);
            postService.save(post2);

        }
    }
}
