package me.shuza.android_mvp.base

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
interface BaseMvpPresenter<in V : BaseMvpView> {
    fun attachView(mvpView: V)
    fun detachView()
}