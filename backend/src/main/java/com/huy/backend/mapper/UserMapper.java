package com.huy.backend.mapper;

import org.mapstruct.Mapper;

import com.huy.backend.dto.request.UserCreationRequest;
import com.huy.backend.entity.User;
@Mapper(componentModel = "spring")
public interface UserMapper {
     User toUser(UserCreationRequest userCreationRequest);
}
