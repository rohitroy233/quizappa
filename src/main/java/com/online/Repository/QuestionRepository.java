package com.online.Repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.online.model.exam.Question;
import com.online.model.exam.Quiz;

public interface QuestionRepository extends JpaRepository<Question,Integer>{

    Set<Question> findByQuiz(Quiz quiz);
    
}
