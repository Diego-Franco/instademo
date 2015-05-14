package com.defch.instademo.model.technicalSpecs;

import io.realm.RealmObject;

/**
 * Created by DiegoFranco on 5/12/15.
 */
public class TechnicalSpecs extends RealmObject {

    private Engine engine;
    private Transmission transmission;
    private Categorie categorie;
    private MPG mpg;

    public TechnicalSpecs() {

    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public MPG getMpg() {
        return mpg;
    }

    public void setMpg(MPG mpg) {
        this.mpg = mpg;
    }

}
