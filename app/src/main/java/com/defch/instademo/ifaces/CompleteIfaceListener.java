package com.defch.instademo.ifaces;

import com.defch.instademo.model.InstaModel;

import io.realm.RealmResults;

/**
 * Created by DiegoFranco on 5/12/15.
 */
public interface CompleteIfaceListener {

    void onCompleteListener(RealmResults<InstaModel> instaModelArrayList);
}
