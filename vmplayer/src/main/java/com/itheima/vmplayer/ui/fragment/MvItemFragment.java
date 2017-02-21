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
import com.itheima.vmplayer.bean.ItemBean;
import com.itheima.vmplayer.bean.MvItemBean;
import com.itheima.vmplayer.dagger.component.DaggerMvItemComponent;
import com.itheima.vmplayer.dagger.modules.MvItemModule;
import com.itheima.vmplayer.presenter.fragment.MvItemPresenter;
import com.itheima.vmplayer.ui.adapter.MvItemAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by xx on 2017/2/18.
 */

public class MvItemFragment extends BaseFragment {
//    @BindView(R.id.mv_item_mv)
//    TextView mMvItemMv;
    @BindView(R.id.mv_item_rv)
    RecyclerView mMvItemRv;
    @BindView(R.id.mv_item_srl)
    SwipeRefreshLayout mMvItemSrl;
    private String mCode;
    @Inject
    public MvItemPresenter mMvItemPresenter;

    private List<ItemBean> datas = new ArrayList<>();
    private MvItemAdapter mMvItemAdapter;


    public static MvItemFragment getInstance(String code) {
        MvItemFragment mvItemFragment = new MvItemFragment();
        Bundle bundle = new Bundle();
        bundle.putString("code", code);
        mvItemFragment.setArguments(bundle);
        return mvItemFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        mCode = bundle.getString("code");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle
            savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mv_item, null);
        ButterKnife.bind(this, view);

        initView();

        return view;
    }

    private void initView() {
        setWidthAndHeight(640, 360);
//        mMvItemMv.setText(mCode);
        mMvItemRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        mMvItemAdapter = new MvItemAdapter(getActivity(), datas, mWidth, mHeight);
        mMvItemRv.setAdapter(mMvItemAdapter);

        mMvItemSrl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                isFresh = true;
                mMvItemPresenter.getData(mCode,offset,size);

            }
        });

        mMvItemRv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (lastVisibleItemPosition + 1 == mMvItemAdapter.getItemCount() && newState != RecyclerView
                        .SCROLL_STATE_DRAGGING&&hasMore) {
                    showDialog();
                    mMvItemPresenter.getData(mCode,offset,size);
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
        DaggerMvItemComponent.builder().mvItemModule(new MvItemModule(this)).build().in(this);
        mMvItemPresenter.getData(mCode, offset, size);
    }

    public void setData(MvItemBean bean) {
        dismissDialog();
        if (isFresh) {
            isFresh = false;
            datas.clear();
        }
        hasMore = bean.getVideos().size()>0;

//        Toast.makeText(getActivity(), "datas.size():" + bean.getVideos().size(), Toast.LENGTH_SHORT).show();
        datas.addAll(bean.getVideos());
        mMvItemAdapter.notifyDataSetChanged();

        mMvItemSrl.setRefreshing(false);
    }
}
