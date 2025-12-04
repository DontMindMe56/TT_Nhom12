package com.example.tt_nhom12.ui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentStateAdapter {
    private final List<Fragment> fragmentList = new ArrayList<>();
    private final List<String> fragmentTitleList = new ArrayList<>();

    public ViewPagerAdapter(@NonNull FragmentActivity fa) {
        super(fa);
    }
    public void addFragment(Fragment fragment, String fragmentTitle){
        fragmentList.add(fragment);
        fragmentTitleList.add(fragmentTitle);
    }
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragmentList.get(position);
    }
    @Override
    public int getItemCount() {
        return fragmentTitleList.size();
    }
}
