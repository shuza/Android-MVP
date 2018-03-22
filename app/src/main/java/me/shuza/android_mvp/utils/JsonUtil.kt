package me.shuza.android_mvp.utils

import com.google.gson.JsonObject
import com.orhanobut.logger.Logger

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

fun hasValidValue(jsonObj: JsonObject, key: String): Boolean {
    return (jsonObj.has(key) && !jsonObj.get(key).isJsonNull)
}

fun getIntFromJson(jsonObj: JsonObject, key: String, defaultValue: Int = 0): Int {
    try {
        return jsonObj.get(key).asInt
    } catch (e: Exception) {
        Logger.e("Error:  ${e.message}")
    }
    return defaultValue
}