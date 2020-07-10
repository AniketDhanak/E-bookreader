package com.akd.in.e_bookreader.ui.favorites;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.akd.in.e_bookreader.adapters.BookAdapter;
import com.akd.in.e_bookreader.R;
import com.android.volley.RequestQueue;

public class FavoritesFragment extends Fragment {

    private FavoritesViewModel favoritesViewModel;

    private RecyclerView mRecyclerView;
    private BookAdapter mBookAdapter;
    private LinearLayoutManager mLinearLayoutManager;
    private RequestQueue mRequestQueue;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        favoritesViewModel =
                ViewModelProviders.of(this).get(FavoritesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_categories, container, false);
        /*final TextView textView = root.findViewById(R.id.text_gallery);
        favoritesViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/

        RecyclerView recyclerView = root.findViewById(R.id.bookView);

        BookAdapter bookAdapter = new BookAdapter();
        recyclerView.setAdapter(bookAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        return root;
    }
}
