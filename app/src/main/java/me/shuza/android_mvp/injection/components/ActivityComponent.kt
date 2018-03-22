package me.shuza.android_mvp.injection.components

import dagger.Component
import me.shuza.android_mvp.fetures.MainActivity
import me.shuza.android_mvp.injection.annotations.PerActivity
import me.shuza.android_mvp.injection.modules.ActivityModule
import me.shuza.android_mvp.injection.modules.NetworkModule

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

@PerActivity
@Component(dependencies = [(ApplicationComponent::class)], modules = [ActivityModule::class, NetworkModule::class])
interface ActivityComponent {
    fun inject(target: MainActivity)
}