package me.shuza.android_mvp.injection.modules

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import me.shuza.android_mvp.injection.annotations.ApplicationContext
import javax.inject.Singleton

/**
 *
 * :=  created by:  Shuza
 * :=  create date:  3/22/2018
 * :=  (C) CopyRight Shuza
 * :=  www.shuza.me
 * :=  shuza.sa@gmail.com
 * :=  Fun  :  Coffee  :  Code
 *
 **/

@Module
class ApplicationModule(private val application: Application) {

    @Provides
    @Singleton
    fun provideApplication(): Application = application

    @Provides
    @ApplicationContext
    fun provideApplicationContext(): Context = application
}