package com.online.services.implementation;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.Repository.QuestionRepository;
import com.online.model.exam.Question;
import com.online.model.exam.Quiz;
import com.online.services.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;
    @Override
    public Question addQuestion(Question question) {
        // TODO Auto-generated method stub
        return this.questionRepository.save(question);
    }

    @Override
    public Question updateQuestion(Question question) {
        // TODO Auto-generated method stub
        return this.questionRepository.save(question);
    }

    @Override
    public Set<Question> getQuestions() {
        // TODO Auto-generated method stub
        return new HashSet<>(this.questionRepository.findAll());
    }

    @Override
    public Question getQuestion(int questionId) {
        // TODO Auto-generated method stub
        return this.questionRepository.findById(questionId).get();
    }

    @Override
    public Set<Question> getQuestionsOfQuiz(Quiz quiz) {
        // TODO Auto-generated method stub
        return this.questionRepository.findByQuiz(quiz);
    }

    @Override
    public void deleteQuestion(int quesId) {
        
        Question question=new Question();
        question.setQuesId(quesId);
        this.questionRepository.delete(question);
    }

    @Override
    public Question get(int questionsId) {
        
        return this.questionRepository.getReferenceById(questionsId);
    }

    
}
