package com.itheima.vmplayer.dagger.component;

import com.itheima.vmplayer.dagger.modules.MvModule;
import com.itheima.vmplayer.ui.fragment.MvFragment;

import dagger.Component;

/**
 * Created by xx on 2017/2/17.
 */
@Component(modules = MvModule.class)
public interface MvComponent {
    void in(MvFragment mvFragment);
}
