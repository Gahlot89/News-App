package com.gahlot.project.gahlot.newsapp.modelClass;

import java.util.ArrayList;

public class mainNewsModel {
    private String status;
    private String totalResults;
    private ArrayList<ModelClass> articles;

    public mainNewsModel(String status, String totalResults, ArrayList<ModelClass> articles) {
        this.status = status;
        this.totalResults = totalResults;
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public ArrayList<ModelClass> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<ModelClass> articals) {
        this.articles = articals;
    }
}
