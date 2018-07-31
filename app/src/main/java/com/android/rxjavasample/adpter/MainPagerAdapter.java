package com.android.rxjavasample.adpter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.android.rxjavasample.fragment.DashboardFragment;
import com.android.rxjavasample.fragment.HomeFragment;
import com.android.rxjavasample.fragment.NotificationFragment;

import java.util.List;

/**
 * FileName: MainPagerAdapter
 * Author: YuXin
 * Date: 2018/7/31 16:30
 * Describe: ${Describe}
 */
public class MainPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> mFragmentList;

    public MainPagerAdapter(FragmentManager fm, List<Fragment> fragmentList) {
        super(fm);
        this.mFragmentList = fragmentList;
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return HomeFragment.newInstance();

            case 1:
                return DashboardFragment.newInstance();

            case 2:
                return NotificationFragment.newInstance();
        }
        return null;
    }
}
