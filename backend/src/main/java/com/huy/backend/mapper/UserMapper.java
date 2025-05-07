package com.huy.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.huy.backend.dto.reponse.UserResponse;
import com.huy.backend.dto.request.UserCreationRequest;
import com.huy.backend.dto.request.UserUpdateRequest;
import com.huy.backend.entity.User;
@Mapper(componentModel = "spring")
public interface UserMapper {
     User toUser(UserCreationRequest userCreationRequest);
     UserResponse toUserResponse(User user);
     void updateUser(@MappingTarget User user, UserUpdateRequest userUpdateRequest);
}
