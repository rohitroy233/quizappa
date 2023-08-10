package com.online.services;

import java.util.List;
import java.util.Set;

import org.springframework.http.ResponseEntity;

import com.online.model.exam.Category;
import com.online.model.exam.Quiz;

public interface QuizService {
    public Quiz addQuiz(Quiz quiz);
    
    public Quiz updateQuiz(Quiz quiz);

    public Set<Quiz> getQuizzes();

    public Quiz getQuiz(int quizId);

    public void deleteQuiz(int quizId);

    public List<Quiz> getQuizzesOfCategory(Category category);
    public List<Quiz> getActiveQuizzes();

    public List<Quiz> getActiveQuizzesOfCategory(Category c);
}
