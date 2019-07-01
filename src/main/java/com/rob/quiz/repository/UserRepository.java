package com.rob.quiz.repository;

import com.rob.quiz.model.MongoUser;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<MongoUser, String> {
    MongoUser findByUsername(String username);
}
