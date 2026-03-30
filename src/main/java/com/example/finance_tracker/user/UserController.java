package com.example.finance_tracker.user;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="api/users/")
public class UserController {

    private final UserService userService;
    UserController(UserService userService){
        this.userService = userService;
    }
    @PostMapping

    public User postUser(@RequestBody User user) {
        userService.createUser(user);
        return user;
    }


}
