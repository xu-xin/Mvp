package com.itheima.vmplayer.presenter.fragment;

import com.itheima.vmplayer.bean.MvItemBean;
import com.itheima.vmplayer.http.HttpCallBack;
import com.itheima.vmplayer.http.HttpManager;
import com.itheima.vmplayer.ui.fragment.MvItemFragment;
import com.itheima.vmplayer.utils.Constant;

import okhttp3.Call;

/**
 * Created by xx on 2017/2/18.
 */

public class MvItemPresenter {
    private MvItemFragment mMvItemFragment;

    public MvItemPresenter(MvItemFragment mvItemFragment) {
        mMvItemFragment = mvItemFragment;
    }

    public void getData(String code, int offset, int size) {
        HttpManager.getHttpManager().addParam("area", code).addParam("offset",offset+"").addParam("size",size+"")
                .get(Constant.MV_ITEM, new HttpCallBack<MvItemBean>() {

                    @Override
                    public void onsuccess(MvItemBean bean) {
                    mMvItemFragment.setData(bean);
                    }

                    @Override
                    public void onFailure(Call call, Exception e) {
                        System.out.println(e);
                    }
                });
    }
}
