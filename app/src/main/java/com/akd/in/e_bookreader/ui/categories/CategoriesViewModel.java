package com.akd.in.e_bookreader.ui.categories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CategoriesViewModel extends ViewModel {

    private MutableLiveData<String> mText;

   /* public CategoriesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }*/

    public LiveData<String> getText() {
        return mText;
    }
}