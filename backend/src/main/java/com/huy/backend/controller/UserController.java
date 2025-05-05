package com.huy.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huy.backend.dto.request.UserCreationRequest;
import com.huy.backend.dto.request.UserUpdateRequest;
import com.huy.backend.entity.User;
import com.huy.backend.service.impl.UserServiceImpl;


@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private  UserServiceImpl userService;

    @PostMapping("/add")
    User createUser(@RequestBody UserCreationRequest request) {
        return userService.createUser(request);
    }
    @GetMapping("/all")
    List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    @GetMapping("/getByUsername")
    User getUserByUsername(@RequestBody String username) {
        return userService.getUserByuserName(username);
    }   
    @GetMapping("/{userID}")
    User getUserById(@PathVariable("userID") String userID) {
        return userService.getUserById(userID);
    }
    @PutMapping("/{userID}")
    User update(@PathVariable String userID, @RequestBody UserUpdateRequest request) {
        return userService.updateUser(userID, request);
    }
    @DeleteMapping("/{userID}")
    String delete(@PathVariable String userID) {
        userService.deleteUser(userID);
        return "User deleted successfully.";
    }    
}
