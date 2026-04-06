package com.example.finance_tracker.accounts;


import com.example.finance_tracker.user.User;
import com.example.finance_tracker.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    private final UserRepository userRepository;
    public AccountService(AccountRepository accountRepository,UserRepository userRepository){
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
    }

    public Account createAccount(Account account, Long userId){
        Optional<User> optionalUser = userRepository.findById(userId);
        User user = optionalUser.orElseThrow(() -> new RuntimeException("User not found"));
        account.setUser(user);
        return accountRepository.save(account);
    }

}
