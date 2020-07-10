package com.akd.in.e_bookreader.ui.AnimeDetail;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class AnimeDetailViewModel {

    private MutableLiveData<String> mText;

    public AnimeDetailViewModel() {
       /* mText = new MutableLiveData<>();
        mText.setValue("This is Favorites fragment");*/
    }

    public LiveData<String> getText() {
        return mText;
    }
}
