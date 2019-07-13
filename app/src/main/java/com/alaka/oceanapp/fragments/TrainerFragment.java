package com.alaka.oceanapp.fragments;

import android.hardware.Sensor;
import android.hardware.SensorManager;
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
import com.alaka.oceanapp.adapters.TrainerAdapter;
import com.alaka.oceanapp.models.TrainResponse;
import com.alaka.oceanapp.utils.ShakeDetector;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.SENSOR_SERVICE;


/**
 * A simple {@link Fragment} subclass.
 */
public class TrainerFragment extends Fragment {
    private RecyclerView recyclerView;
    private SensorManager manager;
    private Sensor mAccelerometer;
    private ShakeDetector shakeDetector;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_trainer, container, false);
        recyclerView = v.findViewById(R.id.recyclerView);

        manager = (SensorManager) getActivity().getSystemService(SENSOR_SERVICE);
        mAccelerometer = manager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        shakeDetector = new ShakeDetector();

        shakeDetector.setOnShakeListener(new ShakeDetector.OnShakeListener() {
            @Override
            public void onShake(int count) {
                getTrainer();
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        getTrainer();
//        Toast.makeText(getActivity(), "Shake detected", Toast.LENGTH_SHORT).show();
        return v;

    }

    private void getTrainer() {

        Url.getEndPoints().getTrainer(Url.cookie).enqueue(new Callback<List<TrainResponse>>() {
            @Override
            public void onResponse(Call<List<TrainResponse>> call, Response<List<TrainResponse>> response) {
                TrainerAdapter adapter = new TrainerAdapter(getActivity(), response.body());
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<TrainResponse>> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public void onResume() {
        super.onResume();
        manager.registerListener(shakeDetector, mAccelerometer,SensorManager.SENSOR_DELAY_UI );
    }

    @Override
    public void onStart() {
        super.onStart();
        manager.registerListener(shakeDetector, mAccelerometer,SensorManager.SENSOR_DELAY_UI );
    }

    @Override
    public void onPause() {
        super.onPause();
        manager.unregisterListener(shakeDetector);
    }

    @Override
    public void onStop() {
        super.onStop();
        manager.unregisterListener(shakeDetector);
    }
}



