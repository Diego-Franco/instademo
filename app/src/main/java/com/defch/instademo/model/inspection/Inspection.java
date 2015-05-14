package com.defch.instademo.model.inspection;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by DiegoFranco on 5/12/15.
 */
public class Inspection extends RealmObject {

    private RealmList<Section> sections;
    private String summary;
    private Technician technician;

    public Inspection() {
    }

    public RealmList<Section> getSections() {
        return sections;
    }

    public void setSections(RealmList<Section> sections) {
        this.sections = sections;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Technician getTechnician() {
        return technician;
    }

    public void setTechnician(Technician technician) {
        this.technician = technician;
    }

}
