package com.example.jiaofenghangks;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.jiaofenghangks.fragment.OneFragment;
import com.example.jiaofenghangks.fragment.TwoFragment;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    private ViewPager mVp;
    private TabLayout mTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
    }

    private void initView() {
        mVp = (ViewPager) findViewById(R.id.vp);
        mTab = (TabLayout) findViewById(R.id.tab);
    //实现viewpager 与tablayout的联动
        final ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new OneFragment());
        fragments.add(new TwoFragment());
        mVp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return fragments.get(i);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });
        mTab.setupWithViewPager(mVp);
        mTab.getTabAt(0).setText("列表");
        mTab.getTabAt(1).setText("收藏");
        mVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
            }
            @Override
            public void onPageSelected(int i) {
            }
            @Override
            public void onPageScrollStateChanged(int i) {
            }
        });
    }
}
