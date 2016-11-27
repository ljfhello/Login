package com.example.changyuan.login;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {
    private ViewPager m_vp;
    private int navIndex = 0;
    private int currIndex = 0;
    private Fragment mfragment1;
    private Fragment mfragment2;
    private Fragment mfragment3;
    private Fragment mfragment4;
    private List<Fragment> fragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        initTitle();
        getView();
        initFragments();
    }

    /**
     * 初始化标题，并加载四个Fragment
     */
    public void initTitle() {
        ((TextView) findViewById(R.id.title)).setText("音乐");
        ((TextView) findViewById(R.id.title_left)).setVisibility(View.INVISIBLE);
        ((TextView) findViewById(R.id.title_right)).setVisibility(View.INVISIBLE);
    }

    private void getView() {
        m_vp = (ViewPager) findViewById(R.id.viewpager);
        mfragment1 = new FirstFragment();
        mfragment2 = new SecondFragment();
        mfragment3 = new ThirdFragment();
        mfragment4 = new FourthFragment();
    }

    /**
     * 初始化页面
     */
    public void initFragments() {
        fragmentList = new ArrayList<Fragment>();
        fragmentList.add(mfragment1);
        fragmentList.add(mfragment2);
        fragmentList.add(mfragment3);
        fragmentList.add(mfragment4);
        findViewById(R.id.nav_search).setOnClickListener(new MyOnClickListener(0));
        findViewById(R.id.nav_home_layout).setOnClickListener(new MyOnClickListener(1));
        findViewById(R.id.nav_selfinfo_layout).setOnClickListener(new MyOnClickListener(2));
        findViewById(R.id.nav_mess_layout).setOnClickListener(new MyOnClickListener(3));
        setNavState(navIndex, 0);
        m_vp.setAdapter(new MyViewPagerAdapter(getSupportFragmentManager()));
        m_vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int arg0) {
                //Log.i("zhi", arg0 + "");
                switch (arg0) {
                    case 0:
                        if (navIndex != 0) {
// 点击之前如果就是这个控件，不变化
                            setNavState(navIndex, 0);
                            navIndex = 0;
                        }
                        break;
                    case 1:
                        if (navIndex != 1) {
// 点击之前如果就是这个控件，不变化
                            setNavState(navIndex, 1);
                            navIndex = 1;
                        }
                        break;
                    case 2:
                        if (navIndex != 2) {
// 点击之前如果就是这个控件，不变化
                            setNavState(navIndex, 2);
                            navIndex = 2;
                        }
                        break;
                    case 3:
                        if (navIndex != 3) {
// 点击之前如果就是这个控件，不变化
                            setNavState(navIndex, 3);
                            navIndex = 3;
                        }
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });
    }

    private void setNavState(int before, int after) {
// 点击之前的那个按钮恢复正常
        switch (before) {

            case 0:
                findViewById(R.id.nav_search_color).setBackgroundResource(R.color.nav_normal);
                ((ImageView) findViewById(R.id.nav_search_img)).setImageResource(R.drawable.musicc);
                ((TextView) findViewById(R.id.nav_search_text)).setTextColor(getResources().getColor(R.color.nav_text_normal));
                break;
            case 1:
                findViewById(R.id.nav_home_color).setBackgroundResource(R.color.nav_normal);
                ((ImageView) findViewById(R.id.nav_home_img)).setImageResource(R.drawable.playa);
                ((TextView) findViewById(R.id.nav_home_text)).setTextColor(getResources().getColor(R.color.nav_text_normal));
                ((TextView) findViewById(R.id.title_right)).setVisibility(View.INVISIBLE);
                break;
            case 2:
                findViewById(R.id.nav_selfinfo_color).setBackgroundResource(R.color.nav_normal);
                ((ImageView) findViewById(R.id.nav_selfinfo_img)).setImageResource(R.drawable.icon_selfinfo_nor);
                ((TextView) findViewById(R.id.nav_selfinfo_text)).setTextColor(getResources().getColor(R.color.nav_text_normal));
                ((TextView) findViewById(R.id.title_left)).setVisibility(View.INVISIBLE);
                break;
            case 3:
                findViewById(R.id.nav_mess_color).setBackgroundResource(R.color.nav_normal);
                ((ImageView) findViewById(R.id.nav_mess_img)).setImageResource(R.drawable.icon_home_nor);
                ((TextView) findViewById(R.id.nav_mess_text)).setTextColor(getResources().getColor(R.color.nav_text_normal));
                break;
            default:
                break;
        }
// 点击到的那个显示状态
        switch (after) {

            case 0:
                findViewById(R.id.nav_search_color).setBackgroundResource(R.color.nav_pressed);
                ((ImageView) findViewById(R.id.nav_search_img)).setImageResource(R.drawable.musiccc);
                ((TextView) findViewById(R.id.nav_search_text)).setTextColor(getResources().getColor(R.color.nav_text_pressed));
                ((TextView) findViewById(R.id.title)).setText("音乐");
                break;
            case 1:
                findViewById(R.id.nav_home_color).setBackgroundResource(R.color.nav_pressed);
                ((ImageView) findViewById(R.id.nav_home_img)).setImageResource(R.drawable.playb);
                ((TextView) findViewById(R.id.nav_home_text)).setTextColor(getResources().getColor(R.color.nav_text_pressed));
                ((TextView) findViewById(R.id.title_right)).setVisibility(View.VISIBLE);
               // ((TextView) findViewById(R.id.title_right)).setText("设置");
                ((TextView) findViewById(R.id.title)).setText("游戏");
                break;
            case 2:
                findViewById(R.id.nav_selfinfo_color).setBackgroundResource(R.color.nav_pressed);
                ((ImageView) findViewById(R.id.nav_selfinfo_img)).setImageResource(R.drawable.icon_selfinfo_sel1);
                ((TextView) findViewById(R.id.nav_selfinfo_text)).setTextColor(getResources().getColor(R.color.nav_text_pressed));
                ((TextView) findViewById(R.id.title_left)).setVisibility(View.VISIBLE);
              //  ((TextView) findViewById(R.id.title_left)).setText("返回");
                ((TextView) findViewById(R.id.title)).setText("分享");
                break;
            case 3:
                findViewById(R.id.nav_mess_color).setBackgroundResource(R.color.nav_pressed);
                ((ImageView) findViewById(R.id.nav_mess_img)).setImageResource(R.drawable.icon_home_nor1);
                ((TextView) findViewById(R.id.nav_mess_text)).setTextColor(getResources().getColor(R.color.nav_text_pressed));
                ((TextView) findViewById(R.id.title)).setText("个人中心");
                break;
            default:
                break;
        }
    }

    public class MyViewPagerAdapter extends FragmentPagerAdapter {
        public MyViewPagerAdapter(FragmentManager fm) {
            super(fm);
// TODO Auto-generated constructor stub
        }

        @Override
        public Fragment getItem(int arg0) {
            return fragmentList.get(arg0);
        }


        @Override
        public int getCount() {
            return fragmentList.size();
        }

    }

    public class MyOnClickListener implements View.OnClickListener {
        private int index = 0;


        public MyOnClickListener(int i) {
            index = i;
            currIndex = i;

        }

        @Override
        public void onClick(View v) {
            m_vp.setCurrentItem(index);


        }
    };
}
