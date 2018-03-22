package me.shuza.android_mvp.models

import com.google.gson.JsonObject

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
class StudentModel {
    var id = 0
    var name = ""
    var age = 0

    fun toJson(): JsonObject {
        val jsobObject = JsonObject()
        jsobObject.addProperty("id", id)
        jsobObject.addProperty("name", name)
        jsobObject.addProperty("age", age)
        return jsobObject
    }

    override fun toString(): String = toJson().toString()
}