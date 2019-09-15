package com.cheatsheet;

import com.cheatsheet.service.QuestionService;

public class Main {

    public static void main(String[] args) {
        System.out.println("****************DEBUG TIME****************");

        QuestionService qS = QuestionService.getInstance();
        qS.create("How Old Are You?", "1. 10\n2. 15\n3. 18\n4. 20");
        qS.create("Choose name of fish", "1. beer\n2. cola\n3. name of fish\n4. salmon");

        System.out.println(qS.get(0));
        System.out.println(qS.get(1));
        System.out.println("******************************************");
    }
}
