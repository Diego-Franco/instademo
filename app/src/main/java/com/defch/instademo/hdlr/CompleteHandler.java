package com.defch.instademo.hdlr;

import android.os.Handler;
import android.os.Message;

import com.defch.instademo.ifaces.CompleteIfaceListener;
import com.defch.instademo.model.InstaModel;

import io.realm.RealmResults;

/**
 * Created by DiegoFranco on 5/12/15.
 */
public class CompleteHandler extends Handler {

    private CompleteIfaceListener completeIfaceListener;

    public CompleteHandler(CompleteIfaceListener completeIfaceListener) {
        this.completeIfaceListener = completeIfaceListener;
    }

    @Override
    public void handleMessage(Message msg) {
        if(completeIfaceListener != null) {
            if(msg != null && msg.obj != null) {
                completeIfaceListener.onCompleteListener((RealmResults<InstaModel>) msg.obj);
            }
        }
    }
}
