package com.defch.instademo;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.defch.instademo.adapter.RInstaAdapter;
import com.defch.instademo.hdlr.CompleteHandler;
import com.defch.instademo.hdlr.InitHandler;
import com.defch.instademo.ifaces.CompleteIfaceListener;
import com.defch.instademo.ifaces.StartIfaceListener;
import com.defch.instademo.model.InstaModel;
import com.defch.instademo.threads.RequestThread;

import butterknife.ButterKnife;
import butterknife.InjectView;
import io.realm.Realm;
import io.realm.RealmResults;


public class MainActivity extends ActionBarActivity implements StartIfaceListener, CompleteIfaceListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    @InjectView(R.id.my_recycler_view)
    ListView mRecyclerView;
    @InjectView(R.id.mtoolbar)
    Toolbar toolbar;

    private Realm realm;
    private long finishTime = 5;
    RInstaAdapter adapter;
    InitHandler initHandler;
    CompleteHandler completeHandler;
    private Thread th;

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.inject(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar(toolbar);
        realm = Realm.getInstance(getApplicationContext());
        initHandler = new InitHandler(this);
        completeHandler = new CompleteHandler(this);
        th = new Thread(new RequestThread(getApplicationContext(), initHandler, completeHandler));
        th.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void activateCounter() {
        new CountDownTimer(finishTime  * 10000, 1000) { // adjust the milli seconds here

            public void onTick(long millisUntilFinished) {
                Log.i(TAG, "timer: " + millisUntilFinished);
            }

            public void onFinish() {
                th = null;
                th = new Thread(new RequestThread(getApplicationContext(), initHandler, completeHandler));
                th.start();
            }
        }.start();
    }

    @Override
    public void onStartListener(){
        //show progressbar
    }

    @Override
    public void onCompleteListener(RealmResults<InstaModel> instaModelArrayList) {
        if(instaModelArrayList != null) {
            instaModelArrayList = realm.where(InstaModel.class).findAll();
            if(adapter == null) {
                adapter = new RInstaAdapter(MainActivity.this, instaModelArrayList, true);
                mRecyclerView.setAdapter(adapter);
            } else {
                adapter.updateRealmResults(instaModelArrayList);
                adapter.notifyDataSetChanged();
            }
            activateCounter();
        }
    }
}
