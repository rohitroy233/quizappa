package com.online.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.online.model.exam.Category;
import com.online.model.exam.Quiz;

public interface QuizRepository extends JpaRepository<Quiz,Integer> {
    public List<Quiz> findBycategory(Category category);


    public List<Quiz> findByActive(Boolean b);

    public List<Quiz> findByCategoryAndActive(Category c, Boolean b);
}
