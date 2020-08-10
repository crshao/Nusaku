package com.example.nusaku.ui.beranda;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nusaku.R;
import com.google.firebase.auth.FirebaseAuth;

import javax.annotation.Nonnull;

public class BerandaFragment extends Fragment {

    private BerandaViewModel berandaViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        berandaViewModel = ViewModelProviders.of(this).get(BerandaViewModel.class);
        View root = inflater.inflate(R.layout.fragment_beranda, container, false);
        final TextView textView = root.findViewById(R.id.text_beranda);

        berandaViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        // Inflate the layout for this fragment
        return root;
    }
}