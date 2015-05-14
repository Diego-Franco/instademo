package com.defch.instademo.model;

import io.realm.RealmObject;

/**
 * Created by DiegoFranco on 5/12/15.
 */
public class BackgroundCheck extends RealmObject {

    private String id;
    private String title;
    private String cDescription;
    private boolean passed;
    private int priority;

    public BackgroundCheck() {

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

    public String getcDescription() {
        return cDescription;
    }

    public void setcDescription(String cDescription) {
        this.cDescription = cDescription;
    }

    public boolean isPassed() {
        return passed;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

}
