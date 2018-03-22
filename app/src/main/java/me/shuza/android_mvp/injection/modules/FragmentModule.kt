package me.shuza.android_mvp.injection.modules

import android.content.Context
import android.support.v4.app.Fragment
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
class FragmentModule(var fragment: Fragment) {
    @Provides
    fun provideFragment(): Fragment = fragment

    @Provides
    fun provideContext(): Context = fragment.context!!
}