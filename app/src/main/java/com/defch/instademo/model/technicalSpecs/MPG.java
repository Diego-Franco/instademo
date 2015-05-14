package com.defch.instademo.model.technicalSpecs;

import org.json.JSONObject;

import io.realm.RealmObject;

/**
 * Created by DiegoFranco on 5/12/15.
 */
public class MPG extends RealmObject {

    private String id;
    private String city;
    private String highway;

    public MPG() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHighway() {
        return highway;
    }

    public void setHighway(String highway) {
        this.highway = highway;
    }

}
