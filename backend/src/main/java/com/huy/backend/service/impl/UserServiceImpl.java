package com.huy.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huy.backend.dto.request.UserCreationRequest;
import com.huy.backend.dto.request.UserUpdateRequest;
import com.huy.backend.entity.User;
import com.huy.backend.exception.AppException;
import com.huy.backend.exception.ErrorCode;
import com.huy.backend.repository.UserRepository;
import com.huy.backend.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(UserCreationRequest userCreationRequest) {
       User user = new User();
        if (userRepository.existsByUsername(userCreationRequest.getUsername())) {
            
            throw new AppException(ErrorCode.USER_EXISTED);
        }
        user.setUsername(userCreationRequest.getUsername());
        user.setPassword(userCreationRequest.getPassword());
        user.setEmail(userCreationRequest.getEmail());
        user.setFirstName(userCreationRequest.getFirstName());
        user.setLastName(userCreationRequest.getLastName());
        user.setDateOfBirth(userCreationRequest.getDateOfBirth());
        user.setAddress(userCreationRequest.getAddress());

        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserByuserName(String username) {
       return userRepository.findByUsername(username);
    }
    
    @Override
    public User getUserById(String userID) {
        
        return userRepository.findById(userID)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));
    }

    @Override
    public User updateUser(String userID, UserUpdateRequest userUpdateRequest) {
        User user = getUserById(userID);
        
        user.setPassword(userUpdateRequest.getPassword());
        user.setEmail(userUpdateRequest.getEmail());
        user.setFirstName(userUpdateRequest.getFirstName());
        user.setLastName(userUpdateRequest.getLastName());
        user.setDateOfBirth(userUpdateRequest.getDateOfBirth());
        user.setAddress(userUpdateRequest.getAddress());


        return userRepository.save(user);
    }

    @Override
    public void deleteUser(String userID) {
       userRepository.deleteById(userID);
        
    }

    
    
    
    
}
