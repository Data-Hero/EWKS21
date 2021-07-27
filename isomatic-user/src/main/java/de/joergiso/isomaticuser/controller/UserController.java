package de.joergiso.isomaticuser.controller;

import de.joergiso.isomaticuser.domain.DeviceDto;
import de.joergiso.isomaticuser.domain.User;
import de.joergiso.isomaticuser.domain.UserDto;
import de.joergiso.isomaticuser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/userservice")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public void createUser(@RequestBody UserDto user) {
        this.userService.createUser(user);
    }

    @PostMapping("/user/{id}")
    public void registerDevice(@PathVariable Long id, @RequestBody DeviceDto deviceDto) {
        this.userService.registerDevice(id, deviceDto);
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable Long id) {
        return this.userService.getUserById(id);
    }

    @GetMapping("/user")
    public List<User> getAll() {
        return this.userService.getAll();
    }

    @PutMapping("/user")
    public void updateUser(@RequestBody User user) {
        this.userService.updateUser(user);
    }
}
