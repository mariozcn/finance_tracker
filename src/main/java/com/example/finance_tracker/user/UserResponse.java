package com.example.finance_tracker.user;

import java.time.LocalDateTime;


public class UserResponse{
    private Long id;
    private String email;
    private String currencyCode;
    private LocalDateTime createdAt;


    public Long getId(){
        return id;
    }

    public String getEmail(){
        return email;
    }

    public String getCurrencyCode(){
        return currencyCode;
    }

    public LocalDateTime getCreatedAt(){
        return createdAt;
    }

    public UserResponse(Long id, String email, String currencyCode, LocalDateTime createdAt){
        this.id           = id;
        this.email        = email;
        this.currencyCode = currencyCode;
        this.createdAt    = createdAt;
    }

    public UserResponse(){
    }
}
