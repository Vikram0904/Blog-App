package com.example.Verlynkblogapplication.services;

import com.example.Verlynkblogapplication.models.Account;
import com.example.Verlynkblogapplication.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AccountRepository accountRepository;

    public Account save(Account account){
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        return accountRepository.save(account);
    }

    public Optional<Account> findByEmail(String email){
        return accountRepository.findOneByEmail(email);
    }
}
