package com.gahlot.project.gahlot.newsapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gahlot.project.gahlot.newsapp.adapter.NewsItemAdapter;
import com.gahlot.project.gahlot.newsapp.R;
import com.gahlot.project.gahlot.newsapp.apiUtilities;
import com.gahlot.project.gahlot.newsapp.modelClass.ModelClass;
import com.gahlot.project.gahlot.newsapp.modelClass.mainNewsModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Technology extends Fragment {
    String api = "2a12a7139a4548ab8c2fdac740cb4d96";
    ArrayList<ModelClass> modelClassArrayList;
    NewsItemAdapter adapter;
    String country = "in";
    private RecyclerView recyclerView;
    String category = "technology";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_technology,null);
        modelClassArrayList = new ArrayList<>();

        recyclerView = view.findViewById(R.id.technologyRV);


        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new NewsItemAdapter(modelClassArrayList,getContext());
        recyclerView.setAdapter(adapter);

        findnews();


        return view;
    }

    private void findnews() {

        apiUtilities.getApiInterface().getCategoryNews(country,category,100,api).enqueue(new Callback<mainNewsModel>() {
            @Override
            public void onResponse(Call<mainNewsModel> call, Response<mainNewsModel> response) {
                if(response.isSuccessful()){

                    modelClassArrayList.addAll(response.body().getArticles());

                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<mainNewsModel> call, Throwable t) {

            }
        });
    }
}