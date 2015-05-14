package com.defch.instademo.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.defch.instademo.R;
import com.defch.instademo.model.InstaModel;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import io.realm.RealmBaseAdapter;
import io.realm.RealmResults;

/**
 * Created by DiegoFranco on 5/13/15.
 */
public class RInstaAdapter extends RealmBaseAdapter<InstaModel> {

    private Context context;
    private RealmResults<InstaModel> results;

    public RInstaAdapter(Context context, RealmResults<InstaModel> realmResults, boolean automaticUpdate) {
        super(context, realmResults, automaticUpdate);
        this.context = context;
        this.results = realmResults;
    }

    @Override
    public View getView(int position, View v, ViewGroup parent) {
        ViewHolder holder;
        if(v == null) {
            v = inflater.inflate(R.layout.item_model, parent, false);
            holder = new ViewHolder();
            holder.carPicture = (ImageView)v.findViewById(R.id.car_picture);
            holder.carPrice = (TextView)v.findViewById(R.id.car_price);
            holder.carName = (TextView)v.findViewById(R.id.car_name);
            holder.carDesc = (TextView)v.findViewById(R.id.car_description);
            v.setTag(holder);
        } else {
            holder = (ViewHolder) v.getTag();
        }

        InstaModel model = results.get(position);
        new LoadIMG(holder.carPicture, model.getImages().get(0).getUri()).execute();
        if(model.getPrice() != null) {
            holder.carPrice.setText(model.getPrice());
        }
        if(model.getStyle() != null) {
            if (model.getStyle().getName() != null) {
                holder.carName.setText(model.getStyle().getName());
            }
        }
        if(model.getDesc() != null) {
            holder.carDesc.setText(model.getDesc());
        }


        return v;
    }

    @Override
    public void updateRealmResults(RealmResults<InstaModel> realmResults) {
        super.updateRealmResults(realmResults);
        this.results = realmResults;
    }

    private class ViewHolder {
        ImageView carPicture;
        TextView carPrice;
        TextView carName;
        TextView carDesc;
    }

    private class LoadIMG extends AsyncTask<Void,Void,Bitmap> {

        private ImageView i;
        private String urlS;

        public LoadIMG(ImageView view, String url) {
            this.i = view;
            this.urlS = url;
        }

        @Override
        protected Bitmap doInBackground(Void... params) {
            URL url = null;
            Bitmap bmp = null;
            try {
                url = new URL(urlS);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = 8;
                bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream(), null, options);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return bmp;
        }


        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            if(bitmap != null) {
                i.setImageBitmap(bitmap);
            }
        }
    }
}
