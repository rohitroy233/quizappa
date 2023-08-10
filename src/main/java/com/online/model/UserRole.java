package com.online.model;

import javax.persistence.*;

@Entity
public class UserRole {

  public UserRole() {
    
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int userRoleID;

  @ManyToOne(fetch = FetchType.EAGER)
  private User user;

  @ManyToOne
  private Role role;

  public int getUserRoleID() {
    return userRoleID;
  }

  public void setUserRoleID(int userRoleID) {
    this.userRoleID = userRoleID;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }
}
