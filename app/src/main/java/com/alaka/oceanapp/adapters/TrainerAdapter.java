package com.alaka.oceanapp.adapters;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alaka.oceanapp.R;
import com.alaka.oceanapp.models.TrainResponse;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class TrainerAdapter extends RecyclerView.Adapter<TrainerAdapter.Holder> {
    private Context context;
    private List<TrainResponse> listTrainer;

    public TrainerAdapter(Context context, List<TrainResponse> listTrainer) {
        this.context = context;
        this.listTrainer = listTrainer;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_trainer, viewGroup, false);
        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int i) {
        TrainResponse trainResponse = listTrainer.get(i);

        holder.tvName.setText(trainResponse.getName());
        holder.tvDesc.setText(trainResponse.getDesc());

        strictMode();
        URL url = null;
        try {
            url = new URL("http://10.0.2.2:3000/uploads/" + trainResponse.getImage());
            holder.imgTrainer.setImageBitmap(BitmapFactory.decodeStream((InputStream) url.getContent()));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void strictMode() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    @Override
    public int getItemCount() {
        return listTrainer.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        private ImageView imgTrainer;
        private TextView tvName, tvDesc;

        public Holder(@NonNull View itemView) {
            super(itemView);
            imgTrainer = itemView.findViewById(R.id.imgTrainer);
            tvName = itemView.findViewById(R.id.tvName);
            tvDesc = itemView.findViewById(R.id.tvDesc);
        }
    }
}
