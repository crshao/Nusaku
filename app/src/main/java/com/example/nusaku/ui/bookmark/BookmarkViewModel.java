package com.example.nusaku.ui.bookmark;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BookmarkViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public BookmarkViewModel()
    {
        mText = new MutableLiveData<>();
        mText.setValue("This is Bookmark");
    }

    public LiveData<String> getText()
    {
        return mText;
    }

}
