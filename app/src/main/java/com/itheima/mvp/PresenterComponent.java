package com.itheima.mvp;

import dagger.Component;

/**
 * Created by xx on 2017/2/15.
 */
@Component(modules = PresenterModule.class)
public interface PresenterComponent {
    void in(MainActivity mainActivity);
}
