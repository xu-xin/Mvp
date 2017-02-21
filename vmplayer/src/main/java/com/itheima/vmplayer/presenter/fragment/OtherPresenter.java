package com.itheima.vmplayer.presenter.fragment;

import com.itheima.vmplayer.bean.MeiNvBean;
import com.itheima.vmplayer.http.HttpCallBack;
import com.itheima.vmplayer.http.HttpManager;
import com.itheima.vmplayer.ui.fragment.OtherFragment;
import com.itheima.vmplayer.utils.Constant;

import okhttp3.Call;

/**
 * Created by xx on 2017/2/18.
 */

public class OtherPresenter {
    private OtherFragment mOtherFragment;

    public OtherPresenter(OtherFragment otherFragment) {
        mOtherFragment = otherFragment;
    }


    public void getData() {
        HttpManager.getHttpManager().get(Constant.MEINV, new HttpCallBack<MeiNvBean>() {

            @Override
            public void onsuccess(MeiNvBean bean) {
                mOtherFragment.setData(bean);
            }

            @Override
            public void onFailure(Call call, Exception e) {

            }
        });
    }
}
