package com.online.controller;



import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.online.helper.UserFoundException;
import com.online.model.Role;
import com.online.model.User;
import com.online.model.UserRole;
import com.online.services.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

@Autowired
private UserService userService;

@Autowired
private BCryptPasswordEncoder bCryptPasswordEncoder;
    //creating user
    @PostMapping("/")
    public User createUser(@RequestBody User user) throws Exception{

    	user.setProfile("null.png");
        user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
        Set<UserRole> roles=new HashSet<>();
        Role role=new Role();
        role.setRoleId(45);
        role.setRoleName("normal");
        UserRole userRole=new UserRole();
        userRole.setUser(user);
        userRole.setRole(role); 
        roles.add(userRole);
        return this.userService.createUser(user, roles);

    }

@GetMapping("/{username}")
public User getUser(@PathVariable("username") String username)
{
    return this.userService.getUser(username);
}

@DeleteMapping("/{userId}")
public void deleteUser(@PathVariable("userId") int userId){
    this.userService.deleteUser(userId);
}

@ExceptionHandler(UserFoundException.class)
public ResponseEntity<?> exceptionHandler(UserFoundException ex) {
    return ResponseEntity.ok(ex.getMessage());
}

}
