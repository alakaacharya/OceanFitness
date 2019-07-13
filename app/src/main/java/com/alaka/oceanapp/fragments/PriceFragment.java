package com.alaka.oceanapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alaka.oceanapp.API.Url;
import com.alaka.oceanapp.R;
import com.alaka.oceanapp.adapters.PriceAdapter;
import com.alaka.oceanapp.models.PriceResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class PriceFragment extends Fragment {
    private RecyclerView recyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_price, container, false);

        recyclerView = v.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        getPrice();
        return v;

    }


    private void getPrice() {

        Url.getEndPoints().getPrice(Url.cookie).enqueue(new Callback<List<PriceResponse>>() {
            @Override
            public void onResponse(Call<List<PriceResponse>> call, Response<List<PriceResponse>> response) {
                if(response.isSuccessful()) {
                    PriceAdapter adapter = new PriceAdapter(getActivity(), response.body());
                    recyclerView.setAdapter(adapter);
                }else{
                    Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<PriceResponse>> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
