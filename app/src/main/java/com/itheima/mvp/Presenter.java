package com.itheima.mvp;

/**
 * Created by xx on 2017/2/14.
 */

public class Presenter {
    private  MainActivity mMainActivity;

    public Presenter(MainActivity mainActivity) {
        this.mMainActivity = mainActivity;
    }

    public void getData() {
        mMainActivity.setData("网络数据");
    }
}
