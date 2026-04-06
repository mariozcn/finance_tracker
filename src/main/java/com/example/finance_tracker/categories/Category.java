package com.example.finance_tracker.categories;


import com.example.finance_tracker.user.User;
import jakarta.persistence.*;

@Entity
@Table(name="categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @Column(name="name")
    private String name;

    @Column(name="type")
    private String type;

    @Column(name="icon_color")
    private String iconColor;

    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setIconColor(String iconColor) {
        this.iconColor = iconColor;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
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

    public Category(Long id, User user, String name, String type, String iconColor) {
        this.id = id;
        this.user = user;
        this.name = name;
        this.type = type;
        this.iconColor = iconColor;
    }

    public Category() {
    }
}
