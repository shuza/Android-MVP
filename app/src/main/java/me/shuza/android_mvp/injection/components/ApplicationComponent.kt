package me.shuza.android_mvp.injection.components

import android.app.Application
import android.content.Context
import dagger.Component
import me.shuza.android_mvp.base.BaseApplication
import me.shuza.android_mvp.injection.annotations.ApplicationContext
import me.shuza.android_mvp.injection.modules.ApplicationModule
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

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(application: BaseApplication)

    @ApplicationContext
    fun context(): Context


    fun application(): Application
}