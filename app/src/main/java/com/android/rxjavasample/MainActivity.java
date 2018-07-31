package com.android.rxjavasample;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.android.rxjavasample.adpter.MainPagerAdapter;
import com.android.rxjavasample.fragment.DashboardFragment;
import com.android.rxjavasample.fragment.HomeFragment;
import com.android.rxjavasample.fragment.NotificationFragment;
import com.android.rxjavasample.view.MainViewPager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Fragment> mFragmentList = new ArrayList<>();
    private MainViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HomeFragment homeFragment = HomeFragment.newInstance();
        DashboardFragment dashboardFragment = DashboardFragment.newInstance();
        NotificationFragment notificationFragment = NotificationFragment.newInstance();
        mFragmentList.add(homeFragment);
        mFragmentList.add(dashboardFragment);
        mFragmentList.add(notificationFragment);

        mViewPager = findViewById(R.id.view_pager);
        MainPagerAdapter mainPagerAdapter = new MainPagerAdapter(getSupportFragmentManager(), mFragmentList);
        mViewPager.setAdapter(mainPagerAdapter);
        mViewPager.setCurrentItem(0);
        mViewPager.setNoScroll(true);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mViewPager.setCurrentItem(0);
                    return true;

                case R.id.navigation_dashboard:
                    mViewPager.setCurrentItem(1);
                    return true;

                case R.id.navigation_notifications:
                    mViewPager.setCurrentItem(2);
                    return true;
            }
            return false;
        }
    };
}
