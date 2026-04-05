package com.example.finance_tracker.accounts;

import com.example.finance_tracker.user.User;
import com.example.finance_tracker.user.UserResponse;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AccountResponse {
    private Long id;
    private String name;
    private String type;
    private BigDecimal currentBalance;
    private LocalDateTime createdAt;
    private UserResponse userResponse;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public UserResponse getUserResponse() {
        return userResponse;
    }

    public AccountResponse(Long id, String name, String type, BigDecimal currentBalance, LocalDateTime createdAt, UserResponse userResponse) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.currentBalance = currentBalance;
        this.createdAt = createdAt;
        this.userResponse = userResponse;
    }

    public AccountResponse() {
    }
}
