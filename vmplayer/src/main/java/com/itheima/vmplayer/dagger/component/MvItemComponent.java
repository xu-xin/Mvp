package com.itheima.vmplayer.dagger.component;

import com.itheima.vmplayer.dagger.modules.MvItemModule;
import com.itheima.vmplayer.ui.fragment.MvItemFragment;

import dagger.Component;

/**
 * Created by xx on 2017/2/18.
 */
@Component(modules = MvItemModule.class)
public interface MvItemComponent {
    void in(MvItemFragment mvItemFragment);
}
