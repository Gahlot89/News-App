package com.gahlot.project.gahlot.newsapp.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.gahlot.project.gahlot.newsapp.fragments.Business;
import com.gahlot.project.gahlot.newsapp.fragments.Entertainment;
import com.gahlot.project.gahlot.newsapp.fragments.Health;
import com.gahlot.project.gahlot.newsapp.fragments.Home;
import com.gahlot.project.gahlot.newsapp.fragments.Science;
import com.gahlot.project.gahlot.newsapp.fragments.Sports;
import com.gahlot.project.gahlot.newsapp.fragments.Technology;

public class NewsAdapter extends FragmentPagerAdapter {

    public NewsAdapter(@NonNull FragmentManager fm, Context context, int tabcount) {
        super(fm);
        this.context = context;
        this.tabcount = tabcount;
    }

    private Context context;
    int tabcount;

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0 : Home home = new Home();
                        return  home;
            case 1 : Business business = new Business();
                        return  business;
            case 2 : Entertainment entertainment = new Entertainment();
                        return entertainment;
            case 3 : Technology technology = new Technology();
                        return technology;
            case 4 : Science science = new Science();
                        return science;
            case 5 : Sports sports = new Sports();
                        return sports;
            case 6 : Health health = new Health();
                        return health;

            default: return null;
        }
    }

    @Override
    public int getCount() {
        return tabcount;
    }
}
