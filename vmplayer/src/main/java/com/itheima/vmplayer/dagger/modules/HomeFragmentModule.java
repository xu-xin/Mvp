package com.itheima.vmplayer.dagger.modules;

import com.itheima.vmplayer.presenter.fragment.HomeFragmentPresenter;
import com.itheima.vmplayer.ui.fragment.HomeFragment;

import dagger.Module;
import dagger.Provides;

/**
 * Created by xx on 2017/2/16.
 */
@Module
public class HomeFragmentModule {
    private HomeFragment mHomeFragment;

    public HomeFragmentModule(HomeFragment homeFragment) {
        mHomeFragment = homeFragment;
    }

    @Provides
    HomeFragmentPresenter provideHomeFragmentPresenter() {
        return new HomeFragmentPresenter(mHomeFragment);
    }
}
