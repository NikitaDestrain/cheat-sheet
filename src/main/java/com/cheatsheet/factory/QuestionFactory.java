package com.cheatsheet.factory;

import com.cheatsheet.pojo.Question;

public class QuestionFactory {
    public static Question create(Integer id, String questionText, String answersText) {
        Question newbie = new Question();
        newbie.setId(id);
        newbie.setQuestionText(questionText);
        newbie.setAnswersText(answersText);
        return newbie;
    }
}
