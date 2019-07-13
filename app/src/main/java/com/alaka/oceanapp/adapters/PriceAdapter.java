package com.alaka.oceanapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alaka.oceanapp.R;
import com.alaka.oceanapp.models.PriceResponse;

import java.util.List;

public class PriceAdapter extends RecyclerView.Adapter<PriceAdapter.Holder> {
    private Context context;
    private List<PriceResponse> listPrice;

    public PriceAdapter(Context context, List<PriceResponse> listPrice) {
        this.context = context;
        this.listPrice = listPrice;
    }

    @NonNull
    @Override
    public PriceAdapter.Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_price, viewGroup, false);
        return new Holder(v);
    }


    @Override
    public void onBindViewHolder(@NonNull PriceAdapter.Holder holder, int i) {

        PriceResponse priceResponse = listPrice.get(i);

        holder.tvName.setText(priceResponse.getName());
        holder.tvOnem.setText(priceResponse.getOnem());
        holder.tvThreem.setText(priceResponse.getThreem());
        holder.tvSixm.setText(priceResponse.getSixm());
        holder.tvOney.setText(priceResponse.getOney());
    }

    @Override
    public int getItemCount() {
        return listPrice.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        private TextView tvName, tvOnem, tvThreem, tvSixm, tvOney;
        public Holder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvOnem = itemView.findViewById(R.id.tvOnem);
            tvThreem = itemView.findViewById(R.id.tvThreem);
            tvSixm = itemView.findViewById(R.id.tvSixm);
            tvOney = itemView.findViewById(R.id.tvOney);
        }
    }
}
