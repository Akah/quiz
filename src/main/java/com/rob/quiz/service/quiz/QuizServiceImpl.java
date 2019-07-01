package com.rob.quiz.service.quiz;

import com.rob.quiz.model.MongoQuiz;
import com.rob.quiz.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizServiceImpl implements QuizService{

    @Autowired
    private QuizRepository repository;

    @Override
    public MongoQuiz getByGroupIdAndAndTitle(String groupId, String title) {
        return repository.getByGroupIdAndAndTitle(groupId, title);
    }

    @Override
    public List<MongoQuiz> getAllByGroupId(String groupId) {
        return repository.getAllByGroupId(groupId);
    }

    @Override
    public void save(MongoQuiz quiz) {
        repository.save(quiz);
    }
}
