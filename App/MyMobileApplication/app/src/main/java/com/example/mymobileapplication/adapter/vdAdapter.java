package com.example.mymobileapplication.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class vdAdapter extends FragmentStatePagerAdapter {
    private  final ArrayList<Fragment> fragment     = new ArrayList<>();
    private  final ArrayList<String> String     = new ArrayList<>();
    public vdAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragment.get(position);
    }

    @Override
    public int getCount() {
        return fragment.size();
    }
    public void addfragment(Fragment fragments, String title){
        fragment.add(fragments);
        String.add(title);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        return String.get(position);
    }
}
