# jkbd_2018.12.5
```
package com.example.dell.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.dell.myapplication.fragment.BlankFragment;
import com.example.dell.myapplication.view.ReaderViewPager;
import com.example.dell.myapplication.view.SlidingUpPanelLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ReaderViewPager mReadviewpage;
    private ImageView mShadowView;
    private SlidingUpPanelLayout mSlidingLayout;
    private ArrayList<String> mlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mlist = initData();
        initEvent();
        intRecyclerViewPager();

    }

    private void intRecyclerViewPager() {
        mReadviewpage.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public int getCount() {
                return mlist.size();
            }

            @Override
            public Fragment getItem(int position) {
                return BlankFragment.newInstance(mlist.get(position), "");
            }
        });
        mReadviewpage.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                mShadowView.setTranslationX(mReadviewpage.getWidth() - positionOffsetPixels);
            }


            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initEvent() {
        mSlidingLayout.addPanelSlideListener(new SlidingUpPanelLayout.PanelSlideListener() {
            @Override
            public void onPanelSlide(View panel, float slideOffset) {

            }

            @Override
            public void onPanelStateChanged(View panel, SlidingUpPanelLayout.PanelState previousState, SlidingUpPanelLayout.PanelState newState) {

            }
        });
    }

    private ArrayList<String> initData() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("测试数据" + i);
        }
        return list;
    }

    private void initView() {
        mReadviewpage = (ReaderViewPager) findViewById(R.id.readviewpage);
        mShadowView = (ImageView) findViewById(R.id.shadowView);
        mSlidingLayout = (SlidingUpPanelLayout) findViewById(R.id.sliding_layout);
    }
}

```
