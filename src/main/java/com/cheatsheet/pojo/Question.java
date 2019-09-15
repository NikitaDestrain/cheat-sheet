package com.cheatsheet.pojo;

import lombok.Data;

@Data
public class Question {
    private Integer id;
    // todo discuss about add short alias for finding optimization, something like "Yes, i am" - "yim"

    private String questionText;
    // todo probably refactor to separate class or list
    private String answersText;
}
