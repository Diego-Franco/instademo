package com.defch.instademo.model;

import org.json.JSONObject;

import io.realm.RealmObject;

/**
 * Created by DiegoFranco on 5/12/15.
 */
public class Owner extends RealmObject {

    private String id;
    private String firstName;
    private String lastName;
    private String photoUrl;

    public Owner() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

}
