package com.rob.quiz.repository;

import com.rob.quiz.model.MongoQuiz;
import com.rob.quiz.model.MongoUser;
import com.rob.quiz.model.Question;
import org.assertj.core.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QuizRepositoryTest {

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private UserRepository userRepository;

    private MongoUser user = new MongoUser("username","password","1","student");

    @Before
    public  void setUp() {
        userRepository.save(user);
        Question question = new Question("text","answer", asList("1","2","3"));
        List<Question> questions = asList(question,question);
        MongoQuiz quiz = new MongoQuiz("title",questions,user.getGroupId(),user.getId());
        quizRepository.save(quiz);
    }

    @After
    public void tearDown() {
        userRepository.deleteAll();
        quizRepository.deleteAll();
    }

    @Test
    public void getByGroupIdAndAndTitleTest() {
        MongoQuiz quiz = quizRepository.getByGroupIdAndAndTitle(user.getGroupId(),"title");
        assertThat(quiz.getGroupId(), is(user.getGroupId()));
        assertThat(quiz.getQuestions().size(), is(2));
    }

    @Test
    public void getAllByGroupIdTest() {
        List<MongoQuiz> quizzes = quizRepository.getAllByGroupId(user.getGroupId());
        assertThat(quizzes.get(0).getGroupId(), is(user.getGroupId()));
        assertThat(quizzes.get(0).getQuestions().size(), is(2));
    }
}