package com.example.nusaku.ui.beranda;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BerandaViewModel extends ViewModel {
    private MutableLiveData<String> mText;
    private FirebaseAuth mAuth;


    public BerandaViewModel()
    {
        mText = new MutableLiveData<>();
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        mText.setValue("Hello" + user.getDisplayName());
    }

    public LiveData<String> getText()
    {
        return mText;
    }
}
