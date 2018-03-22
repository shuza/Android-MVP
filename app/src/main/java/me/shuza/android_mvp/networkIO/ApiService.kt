package me.shuza.android_mvp.networkIO

import io.reactivex.Observable
import me.shuza.android_mvp.models.StudentModel
import retrofit2.http.GET

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
interface ApiService {

    @GET("5ab40b852f00006600ca3a70")
    fun getDataList(): Observable<List<StudentModel>>
}