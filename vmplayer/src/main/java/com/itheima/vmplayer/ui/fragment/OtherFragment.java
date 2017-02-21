package com.itheima.vmplayer.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.itheima.vmplayer.R;
import com.itheima.vmplayer.bean.MeiNvBean;
import com.itheima.vmplayer.dagger.component.DaggerOtherComponent;
import com.itheima.vmplayer.dagger.modules.OtherModule;
import com.itheima.vmplayer.presenter.fragment.OtherPresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by xx on 2017/2/15.
 */

public class OtherFragment extends BaseFragment {


    @BindView(R.id.other_rv)
    RecyclerView mOtherRv;

    @Inject
    public OtherPresenter mOtherPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle
            savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_oter, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        DaggerOtherComponent.builder().otherModule(new OtherModule(this)).build().in(this);
        mOtherPresenter.getData();
    }

    public void setData(MeiNvBean bean) {
        Toast.makeText(getActivity(), "bean.getHintWords().size():" + bean.getHintWords().size(), Toast.LENGTH_SHORT)
                .show();
    }
}
