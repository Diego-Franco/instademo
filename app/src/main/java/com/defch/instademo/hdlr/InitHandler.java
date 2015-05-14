package com.defch.instademo.hdlr;


import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.defch.instademo.ifaces.StartIfaceListener;

/**
 * Created by DiegoFranco on 5/12/15.
 */
public class InitHandler extends Handler {

    private StartIfaceListener startIfaceListener;

    public InitHandler(StartIfaceListener startIfaceListener) {
        this.startIfaceListener = startIfaceListener;
    }

    @Override
    public void handleMessage(Message msg) {
        if(msg.what == 403) {
            Log.w("InitHandler", "warning!");
        }
        if(startIfaceListener != null) {
            startIfaceListener.onStartListener();
        }
    }
}
