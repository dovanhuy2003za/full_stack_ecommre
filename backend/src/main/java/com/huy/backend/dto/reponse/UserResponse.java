package com.huy.backend.dto.reponse;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class UserResponse {
     String id;
     String username;
     String password;
     String email;
     String firstName;
     String lastName;
     LocalDate dateOfBirth;
     String address;
}
