package com.itheima.vmplayer.dagger.component;

import com.itheima.vmplayer.dagger.modules.HomeFragmentModule;
import com.itheima.vmplayer.ui.fragment.HomeFragment;

import dagger.Component;

/**
 * Created by xx on 2017/2/16.
 */
@Component(modules = HomeFragmentModule.class)
public interface HomeFragmentComponent {
    void in(HomeFragment homeFragment);
}
