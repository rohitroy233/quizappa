package com.online.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.online.model.User;

public interface UserRepository extends JpaRepository<User,Integer>{


    public User findByUsername(String useString);
    
}
