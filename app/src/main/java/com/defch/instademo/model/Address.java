package com.defch.instademo.model;

import io.realm.RealmObject;

/**
 * Created by DiegoFranco on 5/12/15.
 */
public class Address extends RealmObject {

    private String id;
    private String avalability;
    private String city;
    private String state;
    private String zipcode;
    private String latitude;
    private String longitude;

    public Address() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAvalability() {
        return avalability;
    }

    public void setAvalability(String avalability) {
        this.avalability = avalability;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

}
