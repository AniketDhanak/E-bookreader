package com.akd.in.e_bookreader.ui.categories;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.akd.in.e_bookreader.R;
import com.akd.in.e_bookreader.adapters.Anime;
import com.akd.in.e_bookreader.adapters.BookAdapter;
import com.akd.in.e_bookreader.adapters.RecyclerViewAdapter;
import com.akd.in.e_bookreader.ui.home.HomeViewModel;
import com.akd.in.e_bookreader.volly.VolleySingleton;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CategoriesFragment extends Fragment {

    private CategoriesViewModel categoriesViewModel;

    private final String JSON_URL = "https://gist.githubusercontent.com/aws1994/f583d54e5af8e56173492d3f60dd5ebf/raw/c7796ba51d5a0d37fc756cf0fd14e54434c547bc/anime.json";
    private JsonArrayRequest request;
    private RequestQueue requestQueue;
    private List<Anime> lstAnime;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter mAdapter;
    private SearchView mSearchView;
    private ProgressDialog progressDialog;


    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        categoriesViewModel =
                ViewModelProviders.of(this).get(CategoriesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_categories, container, false);
        /*final TextView textView = root.findViewById(R.id.text_gallery);
        categoriesViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/


        lstAnime = new ArrayList<>();
        recyclerView = root.findViewById(R.id.recyclerviewid);
        setHasOptionsMenu(true);
        jsonrequest();
        return root;
    }

    private void jsonrequest() {

        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Loding...");
        progressDialog.show();

        request = new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {


            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject = null;



                for (int i = 0; i < response.length(); i++) {


                    try {
                        jsonObject = response.getJSONObject(i);
                        Anime anime = new Anime();
                        anime.setName(jsonObject.getString("name"));
                        anime.setDescription(jsonObject.getString("description"));
                        anime.setRating(jsonObject.getString("Rating"));
                        anime.setCategorie(jsonObject.getString("categorie"));
                        anime.setNb_episode(jsonObject.getInt("episode"));
                        anime.setStudio(jsonObject.getString("studio"));
                        anime.setImg_url(jsonObject.getString("img"));
                        lstAnime.add(anime);
                        progressDialog.dismiss();

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }

                setuprecyclerview(lstAnime);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
            }
        });


        VolleySingleton.getInstance(getContext()).getRequestQueue().add(request);


    }

    private void setuprecyclerview(List<Anime> lstAnime) {


        RecyclerViewAdapter myadapter = new RecyclerViewAdapter(getContext(), lstAnime);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(myadapter);

    }
}
