package com.defch.instademo.model.technicalSpecs;

import io.realm.RealmObject;

/**
 * Created by DiegoFranco on 5/12/15.
 */
public class Categorie extends RealmObject {

    private String market;
    private String classEPA;
    private String vhicleSize;
    private String primaryBodyType;
    private String vehicleStyle;
    private String vehicleType;

    public Categorie() {

    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getClassEPA() {
        return classEPA;
    }

    public void setClassEPA(String classEPA) {
        this.classEPA = classEPA;
    }

    public String getVhicleSize() {
        return vhicleSize;
    }

    public void setVhicleSize(String vhicleSize) {
        this.vhicleSize = vhicleSize;
    }

    public String getPrimaryBodyType() {
        return primaryBodyType;
    }

    public void setPrimaryBodyType(String primaryBodyType) {
        this.primaryBodyType = primaryBodyType;
    }

    public String getVehicleStyle() {
        return vehicleStyle;
    }

    public void setVehicleStyle(String vehicleStyle) {
        this.vehicleStyle = vehicleStyle;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

}
