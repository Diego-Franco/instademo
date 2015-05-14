package com.defch.instademo.model;

import io.realm.RealmObject;

/**
 * Created by DiegoFranco on 5/12/15.
 */
public class Feature extends RealmObject {

    private String id;
    private String name;
    private String slug;
    private String iconUrl;
    private String vehicleFeature;

    public Feature(){
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

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getVehicleFeature() {
        return vehicleFeature;
    }

    public void setVehicleFeature(String vehicleFeature) {
        this.vehicleFeature = vehicleFeature;
    }


}
