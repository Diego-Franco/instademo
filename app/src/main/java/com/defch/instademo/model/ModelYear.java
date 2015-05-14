package com.defch.instademo.model;

import io.realm.RealmObject;

/**
 * Created by DiegoFranco on 5/12/15.
 */
public class ModelYear extends RealmObject {

    private String id;
    private String year;
    private String edmundId;
    private String modelId;

    public ModelYear() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getEdmundId() {
        return edmundId;
    }

    public void setEdmundId(String edmundId) {
        this.edmundId = edmundId;
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

}
