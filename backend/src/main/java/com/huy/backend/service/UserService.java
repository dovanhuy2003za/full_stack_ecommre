package com.huy.backend.service;

import java.util.List;

import com.huy.backend.dto.request.UserCreationRequest;
import com.huy.backend.dto.request.UserUpdateRequest;
import com.huy.backend.entity.User;

public interface UserService {
    User createUser(UserCreationRequest userCreationRequest);
    List<User> getAllUsers();
    User getUserById(String userID);
    User getUserByuserName(String username);
    User updateUser(String userID, UserUpdateRequest userUpdateRequest);
    void deleteUser(String userID);
}
