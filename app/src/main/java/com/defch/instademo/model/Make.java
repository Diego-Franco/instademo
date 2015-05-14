package com.defch.instademo.model;

import io.realm.RealmObject;

/**
 * Created by DiegoFranco on 5/12/15.
 */
public class Make extends RealmObject {

    private String id;
    private String name;
    private String niceName;
    private String edmundId;

    public Make() {
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

    public String getNiceName() {
        return niceName;
    }

    public void setNiceName(String niceName) {
        this.niceName = niceName;
    }

    public String getEdmundId() {
        return edmundId;
    }

    public void setEdmundId(String edmundId) {
        this.edmundId = edmundId;
    }

}
