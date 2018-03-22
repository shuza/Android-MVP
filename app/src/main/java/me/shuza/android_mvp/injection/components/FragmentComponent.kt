package me.shuza.android_mvp.injection.components

import dagger.Component
import me.shuza.android_mvp.injection.annotations.PerFragment
import me.shuza.android_mvp.injection.modules.FragmentModule
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

@PerFragment
@Component(dependencies = [ActivityComponent::class], modules = [FragmentModule::class, NetworkModule::class])
interface FragmentComponent {

}