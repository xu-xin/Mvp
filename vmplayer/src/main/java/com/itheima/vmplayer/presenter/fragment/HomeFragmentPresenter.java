package com.itheima.vmplayer.presenter.fragment;

import com.itheima.vmplayer.bean.VideoBean;
import com.itheima.vmplayer.http.HttpCallBack;
import com.itheima.vmplayer.http.HttpManager;
import com.itheima.vmplayer.ui.fragment.HomeFragment;
import com.itheima.vmplayer.utils.Constant;

import java.util.List;

import okhttp3.Call;

/**
 * Created by xx on 2017/2/16.
 */

public class HomeFragmentPresenter {
    private HomeFragment mHomeFragment;

    public HomeFragmentPresenter(HomeFragment homeFragment) {
        mHomeFragment = homeFragment;
    }

    public void getData(int offset,int size) {
        HttpManager httpManager = HttpManager.getHttpManager();
        httpManager.addParam("offset",""+ offset).addParam("size",size+"");
        httpManager.get(Constant.HOME, new HttpCallBack<List<VideoBean>>() {


            @Override
            public void onsuccess(List<VideoBean> bean) {
                mHomeFragment.setData(bean);
            }

            @Override
            public void onFailure(Call call, Exception e) {
                System.out.println(e);
            }
        });
    }
}
