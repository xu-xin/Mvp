package com.itheima.vmplayer.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.itheima.vmplayer.R;
import com.itheima.vmplayer.bean.AreaBean;
import com.itheima.vmplayer.dagger.component.DaggerMvComponent;
import com.itheima.vmplayer.dagger.modules.MvModule;
import com.itheima.vmplayer.presenter.fragment.MvPresenter;
import com.itheima.vmplayer.ui.adapter.MvAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by xx on 2017/2/15.
 */

public class MvFragment extends BaseFragment {

    @BindView(R.id.mv_tablayout)
    TabLayout mMvTablayout;
    @BindView(R.id.mv_viewpager)
    ViewPager mMvViewpager;
    @Inject
    public MvPresenter mMvPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle
            savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mv, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        DaggerMvComponent.builder().mvModule(new MvModule(this)).build().in(this);
        showDialog();
        mMvPresenter.getData();
    }

    private List<MvItemFragment> fragments = new ArrayList<>();//mv界面的fragment集合

    public void setData(List<AreaBean> datas) {
//        Toast.makeText(getActivity(), "datas.size():" + datas.size(), Toast.LENGTH_SHORT).show();
        dismissDialog();

        initView(datas);
    }

    private void initView(List<AreaBean> datas) {
        for (int i = 0; i < datas.size(); i++) {
            fragments.add(MvItemFragment.getInstance(datas.get(i).getCode()));
        }

        MvAdapter mvAdapter = new MvAdapter(getActivity().getSupportFragmentManager(), fragments, datas);
        mMvViewpager.setAdapter(mvAdapter);

        mMvTablayout.setupWithViewPager(mMvViewpager);
    }
}
