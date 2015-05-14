package com.defch.instademo.model.insurance;

import com.defch.instademo.model.Make;
import com.defch.instademo.model.ModelYear;
import com.defch.instademo.model.VModel;

import io.realm.RealmObject;

/**
 * Created by DiegoFranco on 5/12/15.
 */
public class InsuranceQuote extends RealmObject {

    private String id;
    private String userId;
    private String createdAt;
    private String updatedAt;
    private String cost;
    private Make make;
    private VModel vModel;
    private ModelYear modelYear;
    private InsuranceProvider insuranceProvider;

    public InsuranceQuote() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public Make getMake() {
        return make;
    }

    public void setMake(Make make) {
        this.make = make;
    }

    public VModel getvModel() {
        return vModel;
    }

    public void setvModel(VModel vModel) {
        this.vModel = vModel;
    }

    public ModelYear getModelYear() {
        return modelYear;
    }

    public void setModelYear(ModelYear modelYear) {
        this.modelYear = modelYear;
    }

    public InsuranceProvider getInsuranceProvider() {
        return insuranceProvider;
    }

    public void setInsuranceProvider(InsuranceProvider insuranceProvider) {
        this.insuranceProvider = insuranceProvider;
    }

}
