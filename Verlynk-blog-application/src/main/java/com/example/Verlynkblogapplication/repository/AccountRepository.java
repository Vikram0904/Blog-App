package com.example.Verlynkblogapplication.repository;

import com.example.Verlynkblogapplication.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {
     Optional<Account> findOneByEmail(String email);
}
