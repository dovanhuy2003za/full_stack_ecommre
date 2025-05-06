package com.huy.backend.dto.request;

import java.time.LocalDate;

import lombok.Data;
@Data
public class UserUpdateRequest {
    
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String address;
    
    
}
