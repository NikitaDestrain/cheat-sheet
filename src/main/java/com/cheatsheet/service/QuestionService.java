package com.cheatsheet.service;

import com.cheatsheet.factory.QuestionFactory;
import com.cheatsheet.pojo.Question;
import com.cheatsheet.util.IDGenerator;

import java.util.*;

public class QuestionService {

    private static volatile QuestionService instance;

    // todo probably move to separate class
    private Map<Integer, Question> questions;
    private IDGenerator idGenerator;

    private QuestionService() {
        this.questions = new HashMap<>();
        this.idGenerator = new IDGenerator();
    }

    public static QuestionService getInstance() {
        QuestionService localInstance = instance;
        if (localInstance == null) {
            synchronized (QuestionService.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new QuestionService();
                }
            }
        }
        return localInstance;
    }

    public void create(Integer id, String questionText, String answersText) {
        Question newbie = QuestionFactory.create(id, questionText, answersText);
        this.questions.put(id, newbie);
    }

    public void create(String questionText, String answersText) {
        Integer id = idGenerator.generate();
        Question newbie = QuestionFactory.create(id, questionText, answersText);
        this.questions.put(id, newbie);
    }

    public void remove() {

    }

    public Question get(int id) {
        return questions.get(id);
    }

    // todo return immutable list
    public List<Question> getAll() {
        return null;
    }

    // stub
    public Collection<Question> _getAll() {
        return questions.values();
    }

    public void update() {

    }

    public List<Question> findByPattern(String pattern) {
        return null;
    }

    public void resetIDGenerator() {
        this.idGenerator.reset();
    }

    public void setInitValueToIDGenerator(int initValue) {
        this.idGenerator.setCounter(initValue);
    }
}
