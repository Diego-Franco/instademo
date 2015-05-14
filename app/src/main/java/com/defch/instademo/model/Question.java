package com.defch.instademo.model;

import io.realm.RealmObject;

/**
 * Created by DiegoFranco on 5/12/15.
 */
public class Question extends RealmObject {

    private String id;
    private String question;

    public Question() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

}
