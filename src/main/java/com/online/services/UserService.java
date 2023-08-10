package com.online.services;

import java.util.Set;

import com.online.model.User;
import com.online.model.UserRole;

public interface UserService  {
    public User createUser(User user, Set<UserRole> userRoles) throws Exception;
    
    //get user 
    public User getUser(String username);

    
    public void deleteUser(int userId);
}
