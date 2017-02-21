package com.itheima.vmplayer.dagger.modules;

import com.itheima.vmplayer.presenter.fragment.OtherPresenter;
import com.itheima.vmplayer.ui.fragment.OtherFragment;

import dagger.Module;
import dagger.Provides;

/**
 * Created by xx on 2017/2/18.
 */
@Module
public class OtherModule {
    private OtherFragment mOtherFragment;

    public OtherModule(OtherFragment otherFragment) {
        mOtherFragment = otherFragment;
    }

    @Provides
    public OtherPresenter provideOtherPresenter() {
        return new OtherPresenter(mOtherFragment);
    }
}
