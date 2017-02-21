package com.itheima.vmplayer.ui.activity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.itheima.vmplayer.R;
import com.itheima.vmplayer.ui.fragment.HomeFragment;
import com.itheima.vmplayer.ui.fragment.MusicFragment;
import com.itheima.vmplayer.ui.fragment.MvFragment;
import com.itheima.vmplayer.ui.fragment.OtherFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.main_iv_setting)
    ImageView mMainIvSetting;
    @BindView(R.id.main_fl)
    FrameLayout mMainFl;
    @BindView(R.id.bottomBar)
    BottomBar mBottomBar;
    private Map<Integer, Fragment> mFragments;
    private Fragment mFragment;
    private int mStartX;
    private int mStartY;

    private boolean isBottomShow = true;//记录底部按钮的显示

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initData();
        init();
    }

    private void initData() {
        mFragments = new HashMap<>();
        mFragments.put(R.id.tab_home, new HomeFragment());
        mFragments.put(R.id.tab_mv, new MvFragment());
        mFragments.put(R.id.tab_music, new MusicFragment());
        mFragments.put(R.id.tab_seeting, new OtherFragment());
    }

    private void init() {
        mBottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                Fragment fragment = getFragmentById(tabId);
                switchFragment(fragment);
            }
        });
    }

    private void switchFragment(Fragment fragment) {
        if (fragment == null) {
            return;
        }
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        if (mFragment == null) {
            mFragment = fragment;
        }

        if (mFragment != fragment) {
            if (fragment.isAdded()) {
                fragmentTransaction.hide(mFragment).show(fragment).commit();
            } else {
                fragmentTransaction.hide(mFragment).add(R.id.main_fl, fragment).commit();
            }

            mFragment = fragment;
        } else {
            if (!fragment.isAdded()) {
                fragmentTransaction.add(R.id.main_fl, mFragment).commit();
            }
        }
    }

    private Fragment getFragmentById(int tabId) {

        return mFragments.get(tabId);
    }

    private void initView() {
    }

    @OnClick(R.id.main_iv_setting)
    public void onClick() {
        startActivity(new Intent(MainActivity.this, SettingActivity.class));
    }

    @Override
    public void onBackPressed() {
        final MaterialDialog.Builder builder = new MaterialDialog.Builder(this);
        builder.title("退出提示");
        builder.content("真的要退出吗？");
        builder.positiveText("确定");
        builder.negativeText("点错了");
        builder.onPositive(new MaterialDialog.SingleButtonCallback() {
            @Override
            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                dialog.dismiss();
                finish();
            }
        });
        builder.onNegative(new MaterialDialog.SingleButtonCallback() {
            @Override
            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                dialog.dismiss();
            }
        });

        builder.show();
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mStartX = (int) ev.getRawX();
                mStartY = (int) ev.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:
                int endX = (int) ev.getRawX();
                int endY = (int) ev.getRawY();

                int diffX = endX - mStartX;
                int diffY = endY - mStartY;

                if (Math.abs(diffY) > Math.abs(diffX) && diffY > 10&&!isBottomShow) {//手指向下，显示底部按钮
                    showBottomBar();
                } else if (Math.abs(diffY) > Math.abs(diffX) && diffY < -10&&isBottomShow){//手指向上，隐藏底部按钮
                    hideBottomBar();
                }

                break;
        }
        return super.dispatchTouchEvent(ev);
    }


    private void hideBottomBar() {
        isBottomShow = false;
        ObjectAnimator oa = ObjectAnimator.ofFloat(mBottomBar, "translationY", 0, mBottomBar.getHeight());
        oa.setDuration(300);
        oa.start();
    }

    private void showBottomBar() {
        isBottomShow = true;
        ObjectAnimator oa = ObjectAnimator.ofFloat(mBottomBar, "translationY", mBottomBar.getHeight(), 0);
        oa.setDuration(300);
        oa.start();
    }
}
