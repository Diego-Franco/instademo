package com.defch.instademo.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.defch.instademo.R;
import com.defch.instademo.model.InstaModel;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import io.realm.Realm;

/**
 * Created by DiegoFranco on 5/12/15.
 */
public class InstaAdapter extends RecyclerView.Adapter<InstaAdapter.ViewHolder> {

    private Context context;
    private ArrayList<InstaModel> models;

    public InstaAdapter(Context context, ArrayList<InstaModel> models) {
        this.context = context;
        this.models = models;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_model, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Realm realm = Realm.getInstance(context);
        InstaModel model = models.get(position);

        if(model.getImages().size() > 0) {
            new LoadIMG(holder.carPicture, model.getImages().get(0).getUri()).execute();
        }
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
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView carPicture;
        TextView carPrice;
        TextView carName;
        TextView carDesc;

        public ViewHolder(View v) {
            super(v);
            carPicture = (ImageView)v.findViewById(R.id.car_picture);
            carPrice = (TextView)v.findViewById(R.id.car_price);
            carName = (TextView)v.findViewById(R.id.car_name);
            carDesc = (TextView)v.findViewById(R.id.car_description);
        }
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
                bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
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
