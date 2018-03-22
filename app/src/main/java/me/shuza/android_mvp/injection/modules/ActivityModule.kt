package me.shuza.android_mvp.injection.modules

import android.app.Activity
import android.content.Context
import dagger.Module
import dagger.Provides

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
class ActivityModule(var activity: Activity) {

    @Provides
    fun provideActivity(): Activity {
        return activity
    }

    @Provides
    fun provideContext(): Context {
        return activity
    }
}