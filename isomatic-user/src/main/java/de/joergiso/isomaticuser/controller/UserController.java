package de.joergiso.isomaticuser.controller;

import de.joergiso.isomaticuser.domain.User;
import de.joergiso.isomaticuser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userservice")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public void createUser(@RequestBody User user) {
        this.userService.createUser(user);
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable Long id) {
        return this.userService.getUserById(id);
    }

    @PutMapping("/user")
    public void updateUser(@RequestBody User user) {
        this.userService.updateUser(user);
    }


}
