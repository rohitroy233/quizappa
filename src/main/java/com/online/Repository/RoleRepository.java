package com.online.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.online.model.Role;

public interface RoleRepository extends JpaRepository<Role,Integer>{
    
}
