package com.online;

import com.online.helper.UserFoundException;
import com.online.model.Role;
import com.online.model.User;
import com.online.model.UserRole;
import com.online.services.UserService;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ExamApplication implements CommandLineRunner {
  @Autowired
  private UserService userService;

  @Autowired
  private BCryptPasswordEncoder bCryptPasswordEncoder;

  public static void main(String[] args) {
    SpringApplication.run(ExamApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    System.out.println("STarting code");
    try {
      User user = new User();
      user.setFirstName("Ananth");
      user.setEmail("rohit@mail.com");
      user.setPassword(this.bCryptPasswordEncoder.encode("hello"));
      user.setLastName("Roy");
      user.setUsername("ananthroy33");
      user.setProfile("44.png");
   

      Role role1 = new Role();
      role1.setRoleId(51);
      role1.setRoleName("Admin");

      Set<UserRole> userRoleSet = new HashSet<>();
      UserRole userRole = new UserRole();
      userRole.setRole(role1);
      userRole.setUser(user);
      userRoleSet.add(userRole);
      User user1 = this.userService.createUser(user, userRoleSet);
      System.out.println(user1.getUsername());
    } catch (UserFoundException e) {
      e.printStackTrace();
    }
  }
}
