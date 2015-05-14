package com.defch.instademo.model.technicalSpecs;

import io.realm.RealmObject;

/**
 * Created by DiegoFranco on 5/12/15.
 */
public class Transmission extends RealmObject {

    private String id;
    private String name;
    private String equipmentType;
    private String transmissionType;
    private String numberOfSpeed;

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

    public String getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType;
    }

    public String getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(String transmissionType) {
        this.transmissionType = transmissionType;
    }

    public String getNumberOfSpeed() {
        return numberOfSpeed;
    }

    public void setNumberOfSpeed(String numberOfSpeed) {
        this.numberOfSpeed = numberOfSpeed;
    }

}
