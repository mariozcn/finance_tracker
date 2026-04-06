package com.example.finance_tracker.categories;

import com.example.finance_tracker.user.User;
import com.example.finance_tracker.user.UserRepository;
import com.example.finance_tracker.user.UserResponse;

public class CategoryResponse {
    private Long id;
    private UserResponse user;
    private String name;
    private String type;
    private String iconColor;

    public Long getId() {
        return id;
    }

    public UserResponse getUser() {
        return user;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getIconColor() {
        return iconColor;
    }

    public CategoryResponse(Long id, UserResponse user, String name, String type, String iconColor) {
        this.id = id;
        this.user = user;
        this.name = name;
        this.type = type;
        this.iconColor = iconColor;
    }

    public CategoryResponse() {
    }
}