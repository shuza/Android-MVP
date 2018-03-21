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
interface BaseMvpView {
    fun isNetworkAvailable(): Boolean
    fun showLoadingDialog()
    fun dismissLoadingDialog()
    fun showSuccessMessage(message: String)
    fun showErrorMessage(message: String)
    fun getResourceText(id: Int): String
}