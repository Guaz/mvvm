package com.marcin.wac.mvvmv2.utilities.di

import androidx.multidex.MultiDexApplication

class DaggApp : MultiDexApplication() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }

}