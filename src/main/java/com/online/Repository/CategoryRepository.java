package com.online.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.online.model.exam.Category;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
    
}
