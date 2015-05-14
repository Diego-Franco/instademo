package com.defch.instademo.model.inspection;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by DiegoFranco on 5/12/15.
 */
public class Section extends RealmObject {

    private String key;
    private RealmList<Item> items;

    public Section() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public RealmList<Item> getItems() {
        return items;
    }

    public void setItems(RealmList<Item> items) {
        this.items = items;
    }

}
