package com.itheima.vmplayer.dagger.modules;

import com.itheima.vmplayer.presenter.fragment.MvPresenter;
import com.itheima.vmplayer.ui.fragment.MvFragment;

import dagger.Module;
import dagger.Provides;

/**
 * Created by xx on 2017/2/17.
 */
@Module
public class MvModule {
    private MvFragment mMvFragment;

    public MvModule(MvFragment mvFragment) {
        mMvFragment = mvFragment;
    }

    @Provides
    public MvPresenter provideMvPresenter() {
        return new MvPresenter(mMvFragment);
    }
}
