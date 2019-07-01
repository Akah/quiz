package com.rob.quiz.service.user;

import com.rob.quiz.model.MongoUser;

public interface UserService {

    void save(MongoUser user);

    MongoUser findByUsername(String username);

}
