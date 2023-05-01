package com.example.lutemon;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.lutemon.fragments.FragmentBattle;
import com.example.lutemon.fragments.FragmentDead;
import com.example.lutemon.fragments.FragmentHome;
import com.example.lutemon.fragments.FragmentTrain;

public class TabPagerAdapter extends FragmentStateAdapter {
    public TabPagerAdapter(@NonNull FragmentActivity fragmentActivity) { // Adapter for the tabPageView used in MoveActivity
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position) {
            case 1:
                return new FragmentTrain();
            case 2:
                return new FragmentBattle();
            case 3:
                return new FragmentDead();
            default:
                return new FragmentHome();
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
