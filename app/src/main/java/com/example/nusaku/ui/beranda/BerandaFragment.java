package com.example.nusaku.ui.beranda;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nusaku.R;
import com.example.nusaku.adapter.JenisWisataAdapter;
import com.example.nusaku.models.JenisWisata;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

import javax.annotation.Nonnull;

public class BerandaFragment extends Fragment {

    private BerandaViewModel berandaViewModel;
    private ArrayList<JenisWisata> mJenisWisata = new ArrayList<>();
    private GridLayoutManager layoutManager;

    public BerandaFragment() {
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        berandaViewModel = ViewModelProviders.of(this).get(BerandaViewModel.class);
        View view = inflater.inflate(R.layout.fragment_beranda, container, false);
        final TextView textView = view.findViewById(R.id.text_beranda);

        berandaViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        layoutManager = new GridLayoutManager(getActivity(), 2);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.jenis_wisata_rv);
        recyclerView.setLayoutManager(layoutManager);
        JenisWisataAdapter adapter = new JenisWisataAdapter(mJenisWisata, getActivity());
        recyclerView.setAdapter(adapter);

        // Inflate the layout for this fragment
        return view;
    }
}