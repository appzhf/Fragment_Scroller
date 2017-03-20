package com.example.zhf.fragment_scroller;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.zhf.fragment_scroller.fragment.HomeFragment;
import com.example.zhf.fragment_scroller.fragment.SwtFragment;
import com.example.zhf.fragment_scroller.fragment.WelcomeFragment;


public class MainActivity extends FragmentActivity implements View.OnClickListener {
    private Context context = MainActivity.this;
    public static Toolbar toolbar;
    private RadioButton home, welcome, set;
    private FragmentManager fm;
    private FragmentTransaction ft;
    private int setItem = 0;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);
        initView();
        toolbar.getBackground().setAlpha(0);
        items(0);
    }

    private void initView() {
        fm = getSupportFragmentManager();
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        home = (RadioButton) findViewById(R.id.home1);
        welcome = (RadioButton) findViewById(R.id.welcome);
        set = (RadioButton) findViewById(R.id.set);
        home.setOnClickListener(this);
        welcome.setOnClickListener(this);
        set.setOnClickListener(this);
        home.setTextColor(getResources().getColor(R.color.main));
        toolbar.setTitle("Title");
        toolbar.setSubtitle("subTitle");
        toolbar.setNavigationIcon(R.mipmap.ic_launcher);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "导航菜单", Toast.LENGTH_SHORT).show();
            }
        });

        toolbar.inflateMenu(R.menu.toolbar);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.main_home:
                        setItem = 0;
                        items(setItem);
                        break;
                    case R.id.main_wel:
                        setItem = 1;
                        items(setItem);
                        break;
                    case R.id.main_set:
                        setItem = 2;
                        items(setItem);
                        break;
                    case R.id.search:
                        Toast.makeText(context, "搜索...", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.home1:
                setItem = 0;
                items(setItem);
                break;
            case R.id.welcome:
                setItem = 1;
                items(setItem);
                break;
            case R.id.set:
                setItem = 2;
                items(setItem);
                break;
        }
    }

    private void items(int item) {
        toolbar.getBackground().setAlpha(0);
        if (item == 0) {
            home.setTextColor(getResources().getColor(R.color.main));
            set.setTextColor(getResources().getColor(R.color.main1));
            welcome.setTextColor(getResources().getColor(R.color.main1));
            HomeFragment hf = new HomeFragment();
            ft = fm.beginTransaction().replace(R.id.content, hf);
        } else if (item == 1) {
            home.setTextColor(getResources().getColor(R.color.main1));
            set.setTextColor(getResources().getColor(R.color.main1));
            welcome.setTextColor(getResources().getColor(R.color.main));
            WelcomeFragment wf = new WelcomeFragment();
            ft = fm.beginTransaction().replace(R.id.content, wf);
        } else {
            home.setTextColor(getResources().getColor(R.color.main1));
            set.setTextColor(getResources().getColor(R.color.main));
            welcome.setTextColor(getResources().getColor(R.color.main1));
            SwtFragment sf = new SwtFragment();
            ft = fm.beginTransaction().replace(R.id.content, sf);
        }
        ft.commit();
    }
}
