package com.marcin.wac.mvvmv2.utilities.di;

import com.marcin.wac.mvvmv2.modules.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = AppModule.class)
public interface
AppComponent {
    // Utils
    void inject(DaggApp daggApp);

    void inject(MainActivity mainActivity);
}