package com.akd.in.e_bookreader.ui.downloads;

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

public class DownloadsFragment extends Fragment {

    private DownloadsViewModel downloadsViewModel;


    private RecyclerView mRecyclerView;
    private BookAdapter mBookAdapter;
    private LinearLayoutManager mLinearLayoutManager;
    private RequestQueue mRequestQueue;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        downloadsViewModel =
                ViewModelProviders.of(this).get(DownloadsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_downloads, container, false);
        /*final TextView textView = root.findViewById(R.id.text_slideshow);
        downlodsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
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
