package com.marcin.wac.mvvmv2.utilities.di

import android.content.Context
import com.marcin.wac.mvvmv2.modules.MainViewModelFactory
import com.marcin.wac.mvvmv2.utilities.persistence.IUserSession
import com.marcin.wac.mvvmv2.utilities.persistence.UserSession
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule //    @Singleton
    (private val daggApp: DaggApp) {
    @Provides
    fun provideContext(): Context {
        return daggApp
    }

    @Provides
    @Singleton
    fun provideUserSession(context: Context?): IUserSession {
        return UserSession(context!!)
    }

    @Provides
    fun provideMainViewModelFactory(): MainViewModelFactory {
        return MainViewModelFactory()
    }
}