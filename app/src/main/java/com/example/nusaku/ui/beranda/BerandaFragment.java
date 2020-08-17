package com.example.nusaku.ui.beranda;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nusaku.R;
import com.example.nusaku.adapter.JenisWisataAdapter;
import com.example.nusaku.api.RetrofitBuilder;
import com.example.nusaku.models.DestinationTypeData;
import com.example.nusaku.models.JenisWisata;
import com.example.nusaku.api.ApiService;

import java.util.ArrayList;

public class BerandaFragment extends Fragment {

    private static final String TAG = "BerandaFragment";
    private BerandaViewModel berandaViewModel;
    private ArrayList<JenisWisata> mJenisWisata = new ArrayList<>();
    private GridLayoutManager layoutManager;

    Call<ArrayList<DestinationTypeData>> call;
    ApiService service;
    JenisWisataAdapter adapter;

    public BerandaFragment() {
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        berandaViewModel = ViewModelProviders.of(this).get(BerandaViewModel.class);
        View view = inflater.inflate(R.layout.fragment_beranda, container, false);
        final TextView textView = view.findViewById(R.id.text_beranda);

        service = RetrofitBuilder.createService(ApiService.class);

        layoutManager = new GridLayoutManager(getActivity(), 2);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.jenis_wisata_rv);

        call = service.getDestinationType();
        call.enqueue(new Callback<ArrayList<DestinationTypeData>>() {
            @Override
            public void onResponse(Call<ArrayList<DestinationTypeData>> call, Response<ArrayList<DestinationTypeData>> response) {
                Log.w(TAG, response.body().toString());

                if(response.isSuccessful())
                {
                    ArrayList<DestinationTypeData> arrayList = response.body();
                    adapter = new JenisWisataAdapter(arrayList, getContext());
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<DestinationTypeData>> call, Throwable t) {

            }
        });

        berandaViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });


        // Inflate the layout for this fragment
        return view;
    }
}