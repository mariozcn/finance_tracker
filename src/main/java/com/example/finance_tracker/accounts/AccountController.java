package com.example.finance_tracker.accounts;


import com.example.finance_tracker.user.User;
import com.example.finance_tracker.user.UserResponse;
import com.example.finance_tracker.user.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/accounts/")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public AccountResponse postAccount(@RequestBody Account account, @RequestParam Long userId) {
        Account saved = accountService.createAccount(account, userId);
        User user = saved.getUser();
        UserResponse userResponse = new UserResponse(user.getId(), user.getEmail(), user.getCurrencyCode(), user.getCreatedAt());
        return new AccountResponse(saved.getId(), saved.getName(), saved.getType(), saved.getCurrentBalance(), saved.getCreatedAt(), userResponse);
    }
}