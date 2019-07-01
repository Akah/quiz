package com.rob.quiz.service.quiz;

import com.mongodb.Mongo;
import com.rob.quiz.model.MongoQuiz;

import java.util.List;

public interface QuizService {

    MongoQuiz getByGroupIdAndAndTitle(String groupId, String title);

    List<MongoQuiz> getAllByGroupId(String groupId);

    void save(MongoQuiz quiz);

}
