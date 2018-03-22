package me.shuza.android_mvp.base

import android.app.Application
import android.content.Context
import me.shuza.android_mvp.injection.components.ApplicationComponent
import me.shuza.android_mvp.injection.components.DaggerApplicationComponent
import me.shuza.android_mvp.injection.modules.ApplicationModule

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
class BaseApplication : Application() {
    val component: ApplicationComponent by lazy {
        DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }

    override fun onCreate() {
        super.onCreate()
        component.inject(this)
    }

    companion object {
        fun get(context: Context): BaseApplication = context.applicationContext as BaseApplication
    }
}