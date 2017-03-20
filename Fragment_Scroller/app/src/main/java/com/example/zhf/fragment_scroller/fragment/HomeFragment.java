package com.example.zhf.fragment_scroller.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zhf.fragment_scroller.MainActivity;
import com.example.zhf.fragment_scroller.R;
import com.example.zhf.fragment_scroller.view.TitleScrollView;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements TitleScrollView.OnScrollListener {
    private View view;
    TitleScrollView title;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_home, null);
        super.onCreate(savedInstanceState);
        title = (TitleScrollView) view.findViewById(R.id.scroll);
        title.setScrolListener(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        container = (ViewGroup) view.getParent();
        if (null != container) {
            container.removeAllViewsInLayout();
        }
        return view;
    }

    @Override
    public void onScroll(int scrollY) {
        if (scrollY < 100) {
            MainActivity.toolbar.getBackground().setAlpha(0);
        } else if (scrollY >= 100 && scrollY < 860) {
            MainActivity.toolbar.getBackground().setAlpha((scrollY - 100) / 3);
        } else {
            MainActivity.toolbar.getBackground().setAlpha(255);
        }
    }
}
