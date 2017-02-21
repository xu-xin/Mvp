package com.itheima.vmplayer.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.itheima.vmplayer.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SettingActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.cacheSize)
    TextView mCacheSize;
    @BindView(R.id.rl_clear_chche)
    RelativeLayout mRlClearChche;
    @BindView(R.id.switch_push)
    SwitchCompat mSwitchPush;
    @BindView(R.id.rl_switch_push)
    RelativeLayout mRlSwitchPush;
    @BindView(R.id.switch_loadimg_no_wifi)
    SwitchCompat mSwitchLoadimgNoWifi;
    @BindView(R.id.rl_loadimg_withwifi)
    RelativeLayout mRlLoadimgWithwifi;
    @BindView(R.id.rl_about)
    RelativeLayout mRlAbout;
    @BindView(R.id.activity_setting)
    LinearLayout mActivitySetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @OnClick({R.id.rl_clear_chche, R.id.switch_push, R.id.switch_loadimg_no_wifi, R.id.rl_about})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_clear_chche:
                break;
            case R.id.switch_push:
                //客户端与服务端设置关闭推送
                break;
            case R.id.switch_loadimg_no_wifi:
                break;
            case R.id.rl_about:
                startActivity(new Intent(SettingActivity.this,AboutActivity.class));
                break;
        }
    }
}
