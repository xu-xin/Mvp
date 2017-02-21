package com.itheima.vmplayer.ui.fragment;

import android.support.v4.app.Fragment;

import com.afollestad.materialdialogs.MaterialDialog;

/**
 * Created by xx on 2017/2/16.
 */

public class BaseFragment extends Fragment {
    protected int mWidth,mHeight;
    protected int offset;
    protected final int size = 10;
    protected  int lastVisibleItemPosition;//列表最后一个可见条目索引
    protected boolean isFresh = false;//记录是否是下拉刷新

    protected boolean hasMore = true;//记录是否有下一页数据
    private MaterialDialog mMaterialDialog;


    protected void setWidthAndHeight(int widht, int height) {
        int widthPixels = getActivity().getResources().getDisplayMetrics().widthPixels;
        mWidth = widthPixels;
        mHeight= mWidth*height/widht;
    }

    protected void showDialog() {
        mMaterialDialog = new MaterialDialog.Builder(getActivity())
                .title("正在加载...")
                .progress(true, -1)
                .show();
    }
    protected void dismissDialog() {
        if (mMaterialDialog != null) {
            mMaterialDialog.dismiss();
        }
    }


}
