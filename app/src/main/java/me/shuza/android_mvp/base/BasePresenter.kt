package me.shuza.android_mvp.base

import java.lang.ref.WeakReference

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
open class BasePresenter<V : BaseMvpView> : BaseMvpPresenter<V> {
    var mvpView: WeakReference<V>? = null

    override fun attachView(mvpView: V) {
        this.mvpView = WeakReference(mvpView)
    }

    override fun detachView() {
        mvpView = null
    }
}