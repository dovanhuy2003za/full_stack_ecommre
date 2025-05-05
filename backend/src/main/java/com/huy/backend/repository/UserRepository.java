package com.huy.backend.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.huy.backend.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
       User findByUsername(String username);
}
