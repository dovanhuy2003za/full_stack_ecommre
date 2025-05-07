package com.huy.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huy.backend.dto.reponse.UserResponse;
import com.huy.backend.dto.request.UserCreationRequest;
import com.huy.backend.dto.request.UserUpdateRequest;
import com.huy.backend.entity.User;
import com.huy.backend.exception.AppException;
import com.huy.backend.exception.ErrorCode;
import com.huy.backend.mapper.UserMapper;
import com.huy.backend.repository.UserRepository;
import com.huy.backend.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;
    @Override
    public User createUser(UserCreationRequest userCreationRequest) {
       
        if (userRepository.existsByUsername(userCreationRequest.getUsername())) {
            
            throw new AppException(ErrorCode.USER_EXISTED);
        }
        User user = userMapper.toUser(userCreationRequest);
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
    public UserResponse getUserById(String userID) {
        
        return userMapper.toUserResponse(userRepository.findById(userID)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED)));
    }

    @Override
    public UserResponse updateUser(String userID, UserUpdateRequest userUpdateRequest) {
        User user = userRepository.findById(userID)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));
        
        userMapper.updateUser(user, userUpdateRequest);


        return userMapper.toUserResponse(userRepository.save(user));
    }

    @Override
    public void deleteUser(String userID) {
       userRepository.deleteById(userID);
        
    }

    
    
    
    
}
