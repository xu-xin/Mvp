package com.itheima.mvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import javax.inject.Inject;


public class MainActivity extends AppCompatActivity {

    private Button mButton;
//    private Presenter mPresenter;

    @Inject
    public Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DaggerPresenterComponent.builder().presenterModule(new PresenterModule(this)).build().in(this);
        initView();
    }

    private void initView() {
        mButton = (Button) findViewById(R.id.bt);
//        mPresenter = new Presenter();
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                mPresenter.getData();
                mPresenter.getData();
            }
        });
    }


    public void setData(String data) {
        Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
    }
}
