package com.gahlot.project.gahlot.newsapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.gahlot.project.gahlot.newsapp.R;
import com.gahlot.project.gahlot.newsapp.databinding.NewsItemBinding;
import com.gahlot.project.gahlot.newsapp.modelClass.ModelClass;
import com.gahlot.project.gahlot.newsapp.activitys.webView;

import java.util.ArrayList;

public class NewsItemAdapter extends RecyclerView.Adapter<NewsItemAdapter.viewHolder> {

    ArrayList<ModelClass> modelClassList;
    Context context;

    public NewsItemAdapter(ArrayList<ModelClass> modelClassList, Context context) {
        this.modelClassList = modelClassList;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        int pos = position;
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, webView.class);
                intent.putExtra("url",modelClassList.get(pos).getUrl());
                context.startActivity(intent);
            }
        });

        holder.binding.author.setText(modelClassList.get(position).getAuthor());
        Glide.with(context).load(modelClassList.get(position).getUrlToImage()).into(holder.binding.newsImage);
        holder.binding.headline.setText(modelClassList.get(position).getTitle());
        holder.binding.content.setText(modelClassList.get(position).getDescription());
        holder.binding.published.setText("Published  :  "+modelClassList.get(position).getPublishedAt());
    }

    @Override
    public int getItemCount() {
        return modelClassList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        NewsItemBinding binding;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            binding = NewsItemBinding.bind(itemView);
        }
    }
}
