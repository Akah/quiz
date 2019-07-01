package com.rob.quiz.model;

import java.util.List;

public class Question {

    private String type;
    private String answer;
    private List<Object> options;

    public Question(){}

    public Question(String type, String answer, List<Object> options){
        this.type = type;
        this.answer = answer;
        this.options = options;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public List<Object> getOptions() {
        return options;
    }

    public void setOptions(List<Object> options) {
        this.options = options;
    }

}
