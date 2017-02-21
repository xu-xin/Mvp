package com.itheima.mvp;

import dagger.Module;
import dagger.Provides;

/**
 * Created by xx on 2017/2/14.
 */
@Module
public class PresenterModule {
    private MainActivity mMainActivity;

    public PresenterModule(MainActivity mainActivity) {
        mMainActivity = mainActivity;
    }

    @Provides
    Presenter providePresenter() {
        return new Presenter(mMainActivity);
    }
}
