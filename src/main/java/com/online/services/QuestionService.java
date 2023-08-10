package com.online.services;

import java.util.Set;

import com.online.model.exam.Question;
import com.online.model.exam.Quiz;

public interface QuestionService {
    public Question addQuestion(Question question);

    public Question updateQuestion(Question question);

    public Set<Question> getQuestions();

    public Question getQuestion(int questionId);

    public Set<Question> getQuestionsOfQuiz(Quiz quiz);

    public void deleteQuestion(int quesId);
    
    public Question get(int questionsId);
}
