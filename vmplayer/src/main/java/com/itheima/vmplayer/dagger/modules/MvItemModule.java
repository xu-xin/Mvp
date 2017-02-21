package com.itheima.vmplayer.dagger.modules;

import com.itheima.vmplayer.presenter.fragment.MvItemPresenter;
import com.itheima.vmplayer.ui.fragment.MvItemFragment;

import dagger.Module;
import dagger.Provides;

/**
 * Created by xx on 2017/2/18.
 */
@Module
public class MvItemModule {
    private MvItemFragment mMvItemFragment;

    public MvItemModule(MvItemFragment mvItemFragment) {
        mMvItemFragment = mvItemFragment;
    }

    @Provides
    public MvItemPresenter provideMvItemPresenter() {
        return new MvItemPresenter(mMvItemFragment);
    }
}
