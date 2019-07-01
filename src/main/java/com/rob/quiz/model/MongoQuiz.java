package com.rob.quiz.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "quiz")
public class MongoQuiz {

    @Id
    private String id;
    private String title;
    private List<Question> questions;
    private String groupId;
    private String ownerId;

    public MongoQuiz(){}

    public MongoQuiz(String title, List<Question> questions, String groupId, String ownerId){
        this.title = title;
        this.questions = questions;
        this.groupId = groupId;
        this.ownerId = ownerId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }
}
