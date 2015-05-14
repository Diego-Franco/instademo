package com.defch.instademo.model;

import io.realm.RealmObject;

/**
 * Created by DiegoFranco on 5/12/15.
 */
public class Style extends RealmObject {

    private String id;
    private String name;
    private String edmundId;
    private String trim;
    private String modelYearId;

    public Style() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEdmundId() {
        return edmundId;
    }

    public void setEdmundId(String edmundId) {
        this.edmundId = edmundId;
    }

    public String getTrim() {
        return trim;
    }

    public void setTrim(String trim) {
        this.trim = trim;
    }

    public String getModelYearId() {
        return modelYearId;
    }

    public void setModelYearId(String modelYearId) {
        this.modelYearId = modelYearId;
    }
}
