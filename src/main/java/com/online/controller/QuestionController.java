package com.online.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.online.model.exam.Question;
import com.online.model.exam.Quiz;
import com.online.services.QuestionService;
import com.online.services.QuizService;

@RestController

@RequestMapping("/question")
@CrossOrigin("*")
public class QuestionController {
    @Autowired
    private QuestionService service;
    
    @Autowired
    private  QuizService quizService;

    @PostMapping("/")
    public ResponseEntity<Question> add(@RequestBody Question question){
        return ResponseEntity.ok(this.service.addQuestion(question));
    }

    //update quiz
    @PutMapping("/")
    public ResponseEntity<Question> update(@RequestBody Question question){
        return ResponseEntity.ok(this.service.updateQuestion(question));
    }

    @GetMapping("/quiz/{qid}")
    public ResponseEntity<?> getQuestionsOfQuiz(@PathVariable("qid") int qid){
        // Quiz quiz=new Quiz();
        // quiz.setQid(qid);
        // Set<Question> questionOfQuiz= this.service.getQuestionsOfQuiz(quiz);
        // return ResponseEntity.ok(questionOfQuiz);
        Quiz quiz=this.quizService.getQuiz(qid);
        Set<Question> questions = quiz.getQuestions();
      
        List<Question> list = new ArrayList(questions);
        if (list.size() > Integer.parseInt(quiz.getNoofqsns())) {
            list = list.subList(0, Integer.parseInt(quiz.getNoofqsns() + 1));
        }
        list.forEach((q)->{
            q.setAnswer("");
        });
        Collections.shuffle(list);
        return ResponseEntity.ok(list);
    }
    
    @GetMapping("/quiz/all/{qid}")
    public ResponseEntity<?> getQuestionsOfQuizAdmin(@PathVariable("qid") int qid){
        Quiz quiz=new Quiz();
        quiz.setQid(qid);
        Set<Question> questionOfQuiz= this.service.getQuestionsOfQuiz(quiz);
        return ResponseEntity.ok(questionOfQuiz);

    }
    
    //get single qsn
    @GetMapping("/{quesId}")
    public Question get(@PathVariable("quesId") int quesId){
        return this.service.getQuestion(quesId);
    }
    //delete a quiz api

    @DeleteMapping("/{quesId}")
    public void delete(@PathVariable("quesId") int quesId){
        this.service.deleteQuestion(quesId);
    }
//evaluate quiz
@PostMapping("/eval-quiz")
public ResponseEntity<?> evalQuiz(@RequestBody List<Question> questions){
    double marksGot = 0;
    int correctAnswers = 0;
    int attempted = 0;
    System.out.println(questions);
    for (Question q : questions) {
        //single questions
        Question question = this.service.get(q.getQuesId());
        if (question.getAnswer().equals(q.getGivenAnswer())) {
            //correct
            correctAnswers++;

            double marksSingle = Double.parseDouble(questions.get(0).getQuiz().getMaxMarks()) / questions.size();
            //       this.questions[0].quiz.maxMarks / this.questions.length;
            marksGot += marksSingle;

        }

        if (q.getGivenAnswer() != null) {
            attempted++;
        }
    }
    Map<String, Object> map = Map.of("marksGot", marksGot, "correctAnswers", correctAnswers, "attempted", attempted);
    return ResponseEntity.ok(map);
}

}
