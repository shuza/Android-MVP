package me.shuza.android_mvp.fetures

import me.shuza.android_mvp.base.BaseMvpPresenter
import me.shuza.android_mvp.base.BasePresenter

/**
 *
 * :=  created by:  Shuza
 * :=  create date:  3/23/2018
 * :=  (C) CopyRight Shuza
 * :=  www.shuza.me
 * :=  shuza.sa@gmail.com
 * :=  Fun  :  Coffee  :  Code
 *
 **/
interface MainActivityMvpPresenter<in V : MainActivityMvpView> : BaseMvpPresenter<V> {
    fun fetchDataFromNetwork()
}