package com.rob.quiz.repository;

import com.rob.quiz.model.MongoUser;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository repository;

    @Before
    public void setUp() {
        MongoUser user = new MongoUser("username","password","1","student");
        repository.save(user);
    }

    @After
    public void tearDown() {
        repository.deleteAll();
    }

    @Test
    public void findByUsername() {
        MongoUser user = repository.findByUsername("username");
        assertNotNull(user);
        assertThat(user.getPassword(),is("password"));
        assertThat(user.getGroupId(),is("1"));
        assertThat(user.getRole(), is("student"));
    }
}