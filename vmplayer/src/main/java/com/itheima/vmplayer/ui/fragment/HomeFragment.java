package com.itheima.vmplayer.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.itheima.vmplayer.R;
import com.itheima.vmplayer.bean.VideoBean;
import com.itheima.vmplayer.dagger.component.DaggerHomeFragmentComponent;
import com.itheima.vmplayer.dagger.modules.HomeFragmentModule;
import com.itheima.vmplayer.presenter.fragment.HomeFragmentPresenter;
import com.itheima.vmplayer.ui.adapter.HomeAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by xx on 2017/2/15.
 */

public class HomeFragment extends BaseFragment {
    @Inject
    public HomeFragmentPresenter mHomeFragmentPresenter;
    @BindView(R.id.home_rv)
    RecyclerView mHomeRv;
    @BindView(R.id.home_srl)
    SwipeRefreshLayout mHomeSrl;

    private List<VideoBean> datas = new ArrayList<>();
    private HomeAdapter mHomeAdapter;


    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle
            savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, null);
        ButterKnife.bind(this, view);
        setWidthAndHeight(640,540);
        initView();
        return view;
    }

    private void initView() {
        mHomeRv.setLayoutManager(new LinearLayoutManager(getContext()));
        mHomeAdapter = new HomeAdapter(getActivity(),datas,mWidth,mHeight );
        mHomeRv.setAdapter(mHomeAdapter);

        //设置刷新监听
        mHomeSrl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                isFresh = true;
                mHomeFragmentPresenter.getData(0,10);
            }
        });

        mHomeRv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                System.out.println(newState+"");
                if (lastVisibleItemPosition + 1 == mHomeAdapter.getItemCount() && newState != RecyclerView
                        .SCROLL_STATE_DRAGGING&&hasMore) {
                    showDialog();
                    mHomeFragmentPresenter.getData(offset,size);
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItemPosition = ((LinearLayoutManager) recyclerView.getLayoutManager())
                        .findLastVisibleItemPosition();
            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        DaggerHomeFragmentComponent.builder().homeFragmentModule(new HomeFragmentModule(this)).build().in(this);
        showDialog();
        mHomeFragmentPresenter.getData(0,size);
    }

    public void setData(List<VideoBean> datas) {
//        Toast.makeText(getActivity(), "datas.size():" + datas.size(), Toast.LENGTH_SHORT).show();
        hasMore = datas.size()>0;

        if (isFresh) {
            this.datas.clear();
            isFresh = false;
        }

        this.datas.addAll(datas);
        offset = this.datas.size();

        mHomeAdapter.notifyDataSetChanged();
        mHomeSrl.setRefreshing(false);
        dismissDialog();
    }
}
