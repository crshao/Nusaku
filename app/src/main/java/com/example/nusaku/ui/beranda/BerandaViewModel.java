package com.example.nusaku.ui.beranda;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BerandaViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public BerandaViewModel()
    {
        mText = new MutableLiveData<>();
        mText.setValue("This is Beranda");
    }

    public LiveData<String> getText()
    {
        return mText;
    }
}
