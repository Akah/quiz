package com.rob.quiz.repository;

import com.rob.quiz.model.MongoQuiz;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface QuizRepository extends MongoRepository<MongoQuiz, String> {

    MongoQuiz getByGroupIdAndAndTitle(String groupId, String title);

    List<MongoQuiz> getAllByGroupId(String groupId);

}
