package com.itheima.vmplayer.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.itheima.vmplayer.bean.AreaBean;
import com.itheima.vmplayer.ui.fragment.MvItemFragment;

import java.util.List;

/**
 * Created by xx on 2017/2/18.
 */

public class MvAdapter extends FragmentStatePagerAdapter {
    private List<MvItemFragment> fragments ;
    private List<AreaBean> datas;

    public MvAdapter(FragmentManager fm, List<MvItemFragment> fragments, List<AreaBean> datas) {
        super(fm);
        this.fragments = fragments;
        this.datas = datas;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return datas.get(position).getName();
    }
}
