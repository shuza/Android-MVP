package me.shuza.android_mvp.fetures

import me.shuza.android_mvp.base.BaseMvpView
import me.shuza.android_mvp.models.StudentModel

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
interface MainActivityMvpView : BaseMvpView {
    fun showData(dataList: List<StudentModel>)
}