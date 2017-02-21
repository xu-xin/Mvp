package com.itheima.vmplayer.presenter.fragment;

import com.itheima.vmplayer.bean.AreaBean;
import com.itheima.vmplayer.http.HttpCallBack;
import com.itheima.vmplayer.http.HttpManager;
import com.itheima.vmplayer.ui.fragment.MvFragment;
import com.itheima.vmplayer.utils.Constant;

import java.util.List;

import okhttp3.Call;

/**
 * Created by xx on 2017/2/17.
 */

public class MvPresenter {
    private MvFragment mMvFragment;

    public MvPresenter(MvFragment mvFragment) {
        mMvFragment = mvFragment;
    }

    public void getData() {
        HttpManager.getHttpManager().get(Constant.MV, new HttpCallBack<List<AreaBean>>() {

            @Override
            public void onsuccess(List<AreaBean> datas) {
                mMvFragment.setData(datas);
            }

            @Override
            public void onFailure(Call call, Exception e) {

            }
        });
    }
}
