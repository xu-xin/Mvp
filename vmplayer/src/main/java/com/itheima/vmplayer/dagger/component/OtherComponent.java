package com.itheima.vmplayer.dagger.component;

import com.itheima.vmplayer.dagger.modules.OtherModule;
import com.itheima.vmplayer.ui.fragment.OtherFragment;

import dagger.Component;

/**
 * Created by xx on 2017/2/18.
 */
@Component(modules = OtherModule.class)
public interface OtherComponent {
    void in(OtherFragment otherFragment);
}
